package com.example.elton.fragmenttest.main

import android.support.design.widget.Snackbar
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.elton.fragmenttest.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.support.v4.fragmentTabHost
import org.jetbrains.anko.support.v4.viewPager
import viewcomponent.WeightTextView
import viewcomponent.weightTextView

/**
 * Created by elton on 25/5/2017.
 */

class MainUI: AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        relativeLayout {
            id = R.id.internal
            viewPager {
                id = R.id.view_pager
//                linearLayout {
//                    id = R.id.internal
//                }.lparams {
//                    width = matchParent
//                    height = matchParent
//                }
            }.lparams {
                width = matchParent
                height = matchParent
//                below(R.id.tab_layout)
            }

            tabLayout {
                id = R.id.tab_layout
            }.lparams {
                width = matchParent
                height = wrapContent
                alignParentBottom()
//                topOf(R.id.view_pager)
//                top = R.id.view_pager
            }
        }

    }

    inline fun View.snackbar(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
        val snack = Snackbar.make(this, message, length)
        snack.f()
        snack.show()
    }
}