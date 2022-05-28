package com.jmmc.thephrasalgames.views.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmmc.thephrasalgames.views.menu_nav.MenuNavigationActivity
import com.jmmc.thephrasalgames.databinding.PresentationAnimationBinding

class  PresentationActivity : AppCompatActivity(), IRoutineCounter {
    private var _binding:PresentationAnimationBinding?=null
    private val binding get()=_binding!!

    lateinit var imagePresentatoin: ImagePresentationRoutine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=PresentationAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imagePresentatoin= ImagePresentationRoutine(this,binding.imagePresentation)
        imagePresentatoin.playWords()
    }

    override fun endRoutine() {
        val intent=Intent(this, MenuNavigationActivity::class.java).apply {  }
        startActivity(intent)
    }
}
