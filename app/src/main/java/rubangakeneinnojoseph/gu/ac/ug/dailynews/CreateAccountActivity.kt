package rubangakeneinnojoseph.gu.ac.ug.dailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class CreateAccountActivity : AppCompatActivity() {
    private val mAuth: FirebaseAuth? = null
    private lateinit var accessCreate: FirebaseAuth

    private lateinit var emailCreate: EditText
    private lateinit var passwordCreate: EditText
    private lateinit var createBtn: Button
    private lateinit var loginBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        accessCreate = FirebaseAuth.getInstance()

        emailCreate = findViewById(R.id.emailadd)
        passwordCreate = findViewById(R.id.password)

        createBtn = findViewById(R.id.register)
        loginBtn = findViewById(R.id.access)

        createBtn.setOnClickListener{
            var email: String = emailCreate.text.toString()
            var password: String = passwordCreate.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                accessCreate.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this, "Registration Failed try again", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

        loginBtn.setOnClickListener{
            val remembered = Intent(this, LoginActivity::class.java)
            startActivity(remembered)
            finish()
        }
    }
}