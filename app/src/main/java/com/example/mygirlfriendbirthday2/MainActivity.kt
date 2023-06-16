package com.example.mygirlfriendbirthday2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.mygirlfriendbirthday2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        initSettingPost()

    }

    //편지에 그림 및 이벤트 적용
    fun initSettingPost(){

        binding.ivPost.apply {
            //그림 적용
            Glide.with(this@MainActivity).load(R.raw.post).into(this)
            setOnClickListener { moveLetter() }
        }
    }

    // 편지로 이동.
    fun moveLetter(){
        val intent = Intent(this, LetterActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }


}