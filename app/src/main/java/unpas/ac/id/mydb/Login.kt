package unpas.ac.id.mydb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import unpas.ac.id.mydb.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // session dari shared preference
        if(loadSessionLogin()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            startActivity(intent)
        }

        // fungsi click button login
        binding.btnLogin.setOnClickListener { login() }
    }

    private fun  login() {
        var username: String = binding.usernameInput.text.toString()
        var password: String = binding.passwordInput.text.toString()

        // shared preference
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.apply {
        putString("getUsername", username)
        putString("getPassword", password)
        }.apply()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // chek data session
    private fun  loadSessionLogin():Boolean{
        val  getSharedPreferences:SharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val savedDataUsername:String ?= getSharedPreferences.getString("getUsername",null)
        val savedDataPassword:String ?= getSharedPreferences.getString("getPasssword",null)
        return savedDataPassword != null && savedDataUsername!= null
    }
}