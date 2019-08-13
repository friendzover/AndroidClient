package com.hazewritescode.friendzover.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import android.widget.TextView
import com.hazewritescode.friendzover.LoggedInUser
import com.hazewritescode.friendzover.R
import android.view.View
import android.view.animation.AnimationUtils






class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureLoginButton()
        configureRegisterButton()
        animateStart()
    }

    private fun animateStart(){
    }

    fun configureLoginButton(){
        val button = findViewById<Button>(R.id.loginButton)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            logUserIn {
                if (it.error != null) {
                    val errtext = findViewById<TextView>(R.id.errorTextView)
                    errtext.text = it.error
                } else startActivity(intent)
            }
        }
    }

    fun configureRegisterButton(){
        val button = findViewById<Button>(R.id.registerButton)
        val intent = Intent(this, RegistrationActivity::class.java)

        button.setOnClickListener {
                startActivity(intent)
        }
    }

    fun logUserIn(code: (user: LoggedInUser) -> Unit) {

        val emailTextBox = findViewById<TextView>(R.id.emailTextBox)
        val passwordTextBox = findViewById<TextView>(R.id.passwordTextBox)


        val url: String = getString(R.string.zover_login_route)

        val requestBody = FormBody.Builder()
            .add("email", emailTextBox.text.toString())
            .add("password", passwordTextBox.text.toString())
            .build()

        val request = Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .post(requestBody)
            .build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val user = gson.fromJson(body, LoggedInUser:: class.java)
                response.body?.close()
                    runOnUiThread {
                        code(user)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed response")
            }
        })



    }
}
