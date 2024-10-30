package com.example.gmail_layout

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var lv: ListView

    private val gmailTitle = listOf("duong", "Mai", "Hello", "Pter", "Casillas")

    private val gmailTime = listOf("11:00 PM", "9:22 AM", "7:04 AM", "10:29 AM", "10:30 AM")

    private val gmailText = listOf("Hello",
        "Hello",
        "Hello",
        "Hello",
        "Hello")

    private val myList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.lv)

        val random = Random()
        for (i in gmailTitle.indices) {
            val avatar = gmailTitle[i].first().uppercase()
            val colorAvatar = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
            val drawable = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setSize(50, 50)
                setColor(colorAvatar)
            }
            myList.add(User(avatar, gmailTitle[i], gmailTime[i],gmailText[i], isStarred = false, drawable))
        }

        val adapter = GmailAdapter(this, R.layout.gmail_item, myList)
        lv.adapter = adapter

    }
}