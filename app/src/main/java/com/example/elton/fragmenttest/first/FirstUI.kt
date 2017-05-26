package com.example.elton.fragmenttest.first

import android.view.View
import com.example.elton.fragmenttest.R
import org.jetbrains.anko.*

/**
 * Created by elton on 25/5/2017.
 */

class FirstUI: AnkoComponent<FirstFragment> {
    override fun createView(ui: AnkoContext<FirstFragment>): View = with(ui){
        relativeLayout {
            textView {
                text = "test"
            }

            button {
                id = R.id.clickable
                text = "click"
            }.lparams {
                alignParentRight()
            }
        }
    }
}