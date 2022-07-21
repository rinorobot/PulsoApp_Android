package com.rinosystems.pulsoapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rinosystems.pulsoapp.fragments.ExamenesFragment
import com.rinosystems.pulsoapp.fragments.InformacionFragment
import com.rinosystems.pulsoapp.fragments.NoticiasFragment
import com.rinosystems.pulsoapp.fragments.PublicacionesFragment

class ViewPagerAdapter(fm: FragmentManager, lc: Lifecycle): FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
       return  when(position){
            0 -> {
              NoticiasFragment()
            }
            1 -> {
                ExamenesFragment()
            }
            2 -> {
                PublicacionesFragment()
            }
            3 -> {
                InformacionFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}