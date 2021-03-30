package rubangakeneinnojoseph.gu.ac.ug.dailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)
        val uganda: Button = findViewById<Button>(R.id.connect)

        uganda.setOnClickListener {
            val ugandannews = Intent(this, NilePostActivity::class.java)
            startActivity(ugandannews)
        }

    }
}