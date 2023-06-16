package com.example.mygirlfriendbirthday2

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mygirlfriendbirthday2.Comment.finishComment
import com.example.mygirlfriendbirthday2.databinding.ActivityLetterBinding


//편지가 있는 액티비티

class LetterActivity : AppCompatActivity() {

    val binding by lazy { ActivityLetterBinding.inflate(layoutInflater) }
    lateinit var mediaPlayerPiano: MediaPlayer //기본 브금
    lateinit var mediaPlayerBirth: MediaPlayer //생일 축하 브금
    var idx = 0 // comment idx 셀 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        initSetting()
        settingBGM()
    }


    //편지에 그림 적용
    fun initSetting() {
        binding.background.apply {
            //그림 적용
            Glide.with(this@LetterActivity).load(R.raw.back2).into(this)
            setOnClickListener { backgroundClick() }
        }
        binding.ivBgm.apply {
            Glide.with(this@LetterActivity).load(R.raw.volume).into(this)
            setOnClickListener { clickPianoBGM() }
        }
        binding.ivBgmBirth.apply {
            Glide.with(this@LetterActivity).load(R.raw.volume).into(this)
            setOnClickListener { clickBirthBGM() }
        }
    }

    fun settingBGM() {
        mediaPlayerPiano = MediaPlayer.create(this, R.raw.piano_bgm);
        mediaPlayerPiano.isLooping = true; //무한재생
        mediaPlayerBirth = MediaPlayer.create(this, R.raw.birthday_bgm);
        mediaPlayerBirth.isLooping = true; //무한재생
        //mediaPlayer.start();
    }

    //피아노 브금 선택 시
    fun clickPianoBGM() {
        //만약 버튼을 눌렀을 때
        if (mediaPlayerPiano.isPlaying) { // 실행중이라면
            Glide.with(this@LetterActivity).load(R.raw.volume).into(binding.ivBgm)
            mediaPlayerPiano.pause()
        } else { // 실행하지않는 상태라면
            Glide.with(this@LetterActivity).load(R.raw.volume_mute).into(binding.ivBgm)
            mediaPlayerPiano.start()
        }
    }

    // 생일 브금 선택 시
    fun clickBirthBGM() {
        //만약 버튼을 눌렀을 때
        if (mediaPlayerBirth.isPlaying) { // 실행중이라면
            Glide.with(this@LetterActivity).load(R.raw.volume).into(binding.ivBgmBirth)
            mediaPlayerBirth.pause()
        } else { // 실행하지않는 상태라면
            Glide.with(this@LetterActivity).load(R.raw.volume_mute).into(binding.ivBgmBirth)
            mediaPlayerBirth.start()
        }
    }

    @SuppressLint("SetTextI18n")
    fun backgroundClick() {
        //다 떨어질 때 까지 ++
        binding.comment.apply {
            if(idx < Comment.comment.size){
                text = "$text ${Comment.comment[idx++]}"
            }else{
                binding.tvFrom.apply {
                    text = finishComment
                    visibility = View.VISIBLE
                }
            }
        }

    }


}