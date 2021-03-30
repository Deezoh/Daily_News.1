package rubangakeneinnojoseph.gu.ac.ug.dailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class NilePostActivity : AppCompatActivity() {
    private val nilePost: WebView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nile_post)

        val webnilepost = findViewById<WebView>(R.id.nilepost)
        webnilepost?.webViewClient = WebViewClient()
        webnilepost?.loadUrl("https://nilepost.co.ug/")
        val webSettings = webnilepost?.settings

        webSettings?.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (nilePost!!.canGoBack()){nilePost.goBack()}
        else{
            super.onBackPressed()
        }

    }
}