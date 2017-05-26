package com.example.elton.fragmenttest.second

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.jetbrains.anko.UI
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

/**
 * Created by elton on 25/5/2017.
 */

class SecondFragment : Fragment() {
    lateinit var clickable: Button


    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            relativeLayout {
                textView {
                    text = "dafdas"
                }
            }
        }.view
    }
}