package com.jmmc.thephrasalgames.views.menu_nav.main_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jmmc.thephrasalgames.databinding.MenuFragmentMainBinding

class MainMenuFragment(): Fragment(),IChangeView {

    private var _binding:MenuFragmentMainBinding?=null
    private val binding get()=_binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= MenuFragmentMainBinding.inflate(inflater,container,false)
        val root=binding!!.root
        return root
    }

    override fun changeView() {
        TODO("Not yet implemented")
    }
}