package com.jmmc.thephrasalgames.views.menu_nav

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jmmc.thephrasalgames.R
import com.jmmc.thephrasalgames.databinding.MenuNavigationBinding
import com.jmmc.thephrasalgames.views.menu_nav.about.AboutFragment
import com.jmmc.thephrasalgames.views.menu_nav.main_menu.MainMenuFragment
import com.jmmc.thephrasalgames.views.menu_nav.profile_menu.ProfileFragment
import com.jmmc.thephrasalgames.views.menu_nav.stats_menu.StatsFragment
import com.jmmc.thephrasalgames.viewmodels.MenuModel

class MenuNavigationActivity:AppCompatActivity() {

    val modelItemSelected: MenuModel by viewModels()
    private var _binding: MenuNavigationBinding?=null
    private val binding get()=_binding!!

    private lateinit var fragment: Fragment
    private lateinit var mActionBarToolbar: Toolbar;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=MenuNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mActionBarToolbar=binding.mainToolbar
        setSupportActionBar(mActionBarToolbar)
        getSupportActionBar()!!.setTitle("Welcome")
        fragment=createDashBoard()
        setFragment(fragment)

        modelItemSelected.currentSelection.observe(this, { currentPosition ->
            configSelection(currentPosition)
        })
        binding.navigationMain.setOnItemSelectedListener {
            modelItemSelected.changePosition(it.itemId)
            true
        }
    }
    fun configSelection(selection: Int): Boolean {
        return when(selection){
            R.id.menu_game ->{
                if(!(fragment is MainMenuFragment)){
                    fragment=
                        MainMenuFragment()
                    setFragment(fragment)
                }
                true
            }
            R.id.stats ->{
                if(!(fragment is StatsFragment)){
                    fragment=
                        StatsFragment(getSupportActionBar()!!)
                    setFragment(fragment)
                }
                true
            }
            R.id.profile ->{
                if(!(fragment is ProfileFragment)){
                    fragment=
                        ProfileFragment(getSupportActionBar()!!)
                    setFragment(fragment)
                }
                true
            }
            R.id.about ->{
                if(!(fragment is AboutFragment)){
                    fragment=
                        AboutFragment(getSupportActionBar()!!)
                    setFragment(fragment)
                }
                true
            }
            else->false
        }
    }

    fun createDashBoard():Fragment{
        var dashboard=
            MainMenuFragment()
        return dashboard
    }
    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.game_main_container,fragment)
            .disallowAddToBackStack()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}