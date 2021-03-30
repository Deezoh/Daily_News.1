package rubangakeneinnojoseph.gu.ac.ug.dailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private val mAuth: FirebaseAuth? = null
    private lateinit var access_auth: FirebaseAuth
    private lateinit var emailAddress: EditText
    private lateinit var passwordArea: EditText
    private lateinit var loginNob: Button
    private lateinit var createNob: Button
    private lateinit var resetPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailAddress = findViewById(R.id.emailadd)
        passwordArea = findViewById(R.id.password)
        loginNob = findViewById(R.id.login)
        createNob = findViewById(R.id.create)
        resetPassword = findViewById(R.id.forgotpasslog)
        // Initialize Firebase Auth
        access_auth = FirebaseAuth.getInstance()

        loginNob.setOnClickListener {
            var email: String = emailAddress.text.toString()
            var password: String = passwordArea.text.toString()
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                //slits strings
                Toast.makeText(this@LoginActivity, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                access_auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val connect = Intent(this, SourceActivity::class.java)
                        startActivity(connect)
                        finish()
                    }else {
                        Toast.makeText(this, "Failed to Login", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

        createNob.setOnClickListener{
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
            finish()
        }

        resetPassword.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}