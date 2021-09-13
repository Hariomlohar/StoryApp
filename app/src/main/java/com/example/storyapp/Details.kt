package com.example.storyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val sTitle = intent.getStringExtra("storytitle")
        val scontant = intent.getStringExtra("storycontant")
        val simages= intent.getStringExtra("storyimage")


        supportActionBar?.title=sTitle
        Picasso.get().load(simages).into(storyfeatureimage)
        storyDtails.text= scontant
    }
}