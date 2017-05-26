package com.example.elton.fragmenttest.main

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.example.elton.fragmenttest.R
import com.example.elton.fragmenttest.SampleFragmentPagerAdapter
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager;

    companion object {
        lateinit var firstFragment: Fragment
        lateinit var secondFragement: Fragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI().setContentView(this)

        val actionBar = actionBar

        viewPager = findViewById(R.id.view_pager) as ViewPager
        val tabLayout = findViewById(R.id.tab_layout) as TabLayout

        viewPager.adapter = SampleFragmentPagerAdapter(fragmentManager, this)
//        tabLayout.setSelectedTabIndicatorColor(0)
        tabLayout.setupWithViewPager(viewPager)
//        tabLayout.getTabAt(0)!!.setIcon(R.drawable.abc_btn_check_material)
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        if (firstFragment.childFragmentManager.backStackEntryCount > 0)
                            firstFragment.childFragmentManager.popBackStack()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> tabLayout.getTabAt(tab!!.position)!!.setIcon(R.drawable.abc_btn_check_material)
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        tabLayout.getTabAt(tab!!.position)!!.setIcon(R.drawable.abc_btn_check_to_on_mtrl_015)
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        val now = viewPager.currentItem
        if (now == 0) {
            if (firstFragment.childFragmentManager.backStackEntryCount > 0)
                return firstFragment.childFragmentManager.popBackStack()
        }
        super.onBackPressed()
    }
}
