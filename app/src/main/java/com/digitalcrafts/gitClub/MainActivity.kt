package com.digitalcrafts.gitClub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.digitalcrafts.gitClub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflated = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inflated.root)
        binding = inflated
    }
}