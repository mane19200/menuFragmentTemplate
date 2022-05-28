package com.jmmc.thephrasalgames.views.menu_nav.profile_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.jmmc.thephrasalgames.databinding.MenuFragmentProfileBinding


class ProfileFragment():Fragment() {

    private var _binding: MenuFragmentProfileBinding?=null
    private val binding get()=_binding
    private lateinit var actionBar: ActionBar

    constructor(actionBar: ActionBar):this(){
        this.actionBar=actionBar
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        actionBar.setTitle("User profile")
        _binding= MenuFragmentProfileBinding.inflate(inflater,container,false)
        val root=binding!!.root
        return root
    }
}