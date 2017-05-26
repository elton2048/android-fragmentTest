package com.example.elton.fragmenttest

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.support.v13.app.FragmentPagerAdapter
import android.view.ViewGroup

import com.example.elton.fragmenttest.first.FirstFragment
import com.example.elton.fragmenttest.main.MainActivity
import com.example.elton.fragmenttest.main.MainFragment
import com.example.elton.fragmenttest.second.SecondFragment

/**
 * Created by elton on 25/5/2017.
 */

class SampleFragmentPagerAdapter
constructor(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {

    val PAGE_COUNT = 2
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return MainFragment.newInstance("first")
            1 -> {
                return MainFragment.newInstance("test")
            }
            else -> {
                return MainFragment.newInstance("")
            }
        }
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val createdFragement = super.instantiateItem(container, position)
        when (position) {
            0 -> MainActivity.firstFragment = createdFragement as Fragment
            1 -> MainActivity.secondFragement = createdFragement as Fragment
        }
        return createdFragement
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }


}