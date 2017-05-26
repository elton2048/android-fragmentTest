package com.example.elton.fragmenttest.third

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.elton.fragmenttest.R
import org.jetbrains.anko.UI
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

/**
 * Created by elton on 26/5/2017.
 */

class ThirdFragment : Fragment() {
    lateinit var clickable: Button


    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            relativeLayout {
                backgroundColor = R.color.material_blue_grey_950
                textView {
                    text = "third"
                }
            }
        }.view
    }
}
