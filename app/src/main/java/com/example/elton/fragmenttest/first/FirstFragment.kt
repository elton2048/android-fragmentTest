package com.example.elton.fragmenttest.first

import android.os.Bundle
import android.app.Fragment
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.app.Fragment as v4Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.elton.fragmenttest.R
import com.example.elton.fragmenttest.second.SecondFragment
import com.example.elton.fragmenttest.third.ThirdFragment
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.act

/**
 * Created by elton on 25/5/2017.
 */

class FirstFragment : Fragment() {
    lateinit var clickable: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = FirstUI().createView(AnkoContext.create(activity, this))
        clickable = view.findViewById(R.id.clickable) as Button

        val tabLayout = activity.findViewById(R.id.tab_layout) as TabLayout
        val viewPager = activity.findViewById(R.id.view_pager) as ViewPager
        clickable.setOnClickListener {
            fragmentManager.beginTransaction()
//                    .remove(this)
                    .replace(R.id.fragment, ThirdFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
        }

        return view
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}