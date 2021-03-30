package rubangakeneinnojoseph.gu.ac.ug.dailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private val mAuth: FirebaseAuth? = null
    private lateinit var authPassReset: FirebaseAuth
    private lateinit var emailAddress: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        authPassReset = FirebaseAuth.getInstance()
        emailAddress = findViewById(R.id.emailreset)
        resetPasswordButton = findViewById(R.id.resetpass)
        backButton = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            finish()
        }
        resetPasswordButton.setOnClickListener {
            var email: String = emailAddress.text.toString()
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter email address", Toast.LENGTH_LONG).show()
            } else {
                authPassReset.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Check you mail for a reset link", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(this, "Failed to send reset link", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }
    }
}