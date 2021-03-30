package rubangakeneinnojoseph.gu.ac.ug.dailynews

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics

class SplashActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private val SPLASH_DURATION = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        Handler().postDelayed({
            val splash = Intent(this,LoginActivity::class.java)
            startActivity(splash)
            finish()
        },SPLASH_DURATION
        )

    }
}