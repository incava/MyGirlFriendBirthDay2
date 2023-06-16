package com.example.mygirlfriendbirthday2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mygirlfriendbirthday2.databinding.ActivityLetterBinding


//편지가 있는 액티비티

class LetterActivity : AppCompatActivity() {

    val binding by lazy { ActivityLetterBinding.inflate(layoutInflater) }
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initSetting()
        settingBGM()
    }


    //편지에 그림 적용
    fun initSetting(){
        binding.background.apply {
            //그림 적용
            Glide.with(this@LetterActivity).load(R.raw.back).into(this)
        }
        binding.ivBgm.apply {
            Glide.with(this@LetterActivity).load(R.raw.volume).into(this)
            setOnClickListener { clickBGM() }
        }
    }

    fun settingBGM(){
        mediaPlayer = MediaPlayer.create(this, R.raw.piano_bgm);
        //mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.start();
    }


    fun clickBGM(){
        //만약 버튼을 눌렀을 때
        if(mediaPlayer.isPlaying){ // 실행중이라면
            Glide.with(this@LetterActivity).load(R.raw.volume_mute).into(binding.ivBgm)
            mediaPlayer.pause()
        }
        else{ // 실행하지않는 상태라면
            Glide.with(this@LetterActivity).load(R.raw.volume).into(binding.ivBgm)
            mediaPlayer.start()
        }
    }



}