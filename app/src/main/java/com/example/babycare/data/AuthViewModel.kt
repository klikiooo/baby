package com.example.zawadiland.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.zawadiland.navigation.ROUT_HOME
import com.example.zawadiland.navigation.ROUT_LOGIN
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(var navController:NavHostController, var context:Context) {
    var mAuth:FirebaseAuth
    init {
        mAuth = FirebaseAuth.getInstance()
    }
    fun signup(email:String, password:String){
        Toast.makeText(context, "Clicked $email", Toast.LENGTH_SHORT).show()
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context, "Register successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUT_HOME)
            }else{
                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun login(email:String, password:String){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUT_HOME)
            }
        }
    }

    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUT_LOGIN)
    }

    fun isLoggedIn():Boolean{
        return mAuth.currentUser != null
    }
}