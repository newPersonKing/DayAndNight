package com.gy.dayandnight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,DayAndNightActivity::class.java)
        rg_group.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rb_one ->{
                    intent.putExtra("isNight",false)
                }
                R.id.rb_two ->{
                    intent.putExtra("isNight",true)
                }
            }
        }

        btn_sure.setOnClickListener {
            startActivity(intent)
        }
    }
}