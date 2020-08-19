package com.leo.meettheteam.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.leo.meettheteam.R
import com.leo.meettheteam.adapters.TeamAdapter
import com.leo.meettheteam.databinding.ActivityMainBinding
import com.leo.meettheteam.utils.Extensions.openActivity
import com.leo.meettheteam.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val viewModel: MainViewModel by viewModels()

        viewModel.getUsers().observe(this, Observer {
            binding.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            binding.adapter = TeamAdapter(it)
        })
    }
}
