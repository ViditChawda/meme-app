package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.nextBtn)
        btn.setOnClickListener{
            btn.setText("NEXT MEME")
            loadMeme()
        }

    }
    fun loadMeme(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
// Request a string response from the provided URL.
        val jasonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener{ response ->
             val url = response.getString("url")
                val memeImageView = findViewById<ImageView>(R.id.memeImageView)
               Glide.with(this).load(url).into(memeImageView)
//                Log.d("success request", response.toString())

            },
            Response.ErrorListener {
                Toast.makeText(this, "Something went wrong" , Toast.LENGTH_LONG).show()
            })

// Add the request to the RequestQueue.
        queue.add(jasonObjectRequest)

    }
    fun Nextme(view: android.view.View) {
        loadMeme()
    }
    fun ShareMe(view: android.view.View) {

    }
}