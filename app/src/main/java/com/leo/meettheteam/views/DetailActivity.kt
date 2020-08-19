package com.leo.meettheteam.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leo.meettheteam.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = "Team Detail"
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}