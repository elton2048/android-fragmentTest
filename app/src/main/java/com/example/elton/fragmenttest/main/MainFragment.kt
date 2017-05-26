package com.example.elton.fragmenttest.main

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elton.fragmenttest.R
import com.example.elton.fragmenttest.first.FirstFragment
import com.example.elton.fragmenttest.second.SecondFragment
import org.jetbrains.anko.UI
import org.jetbrains.anko.frameLayout

/**
 * Created by elton on 26/5/2017.
 */

class MainFragment : Fragment() {
    companion object {
        fun newInstance(data: String): Fragment {
            val frag = MainFragment()
            val args = Bundle()
            args.putString("data", data)
            frag.arguments = args

            return frag
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = UI {
            frameLayout {
                id = R.id.fragment
            }
        }.view
        val data = arguments.getString("data")
        val transaction = childFragmentManager.beginTransaction()
        when (data) {
            "first" -> transaction.add(R.id.fragment, FirstFragment())
            else -> {
                transaction.add(R.id.fragment, SecondFragment.newInstance())
            }
        }
        transaction.commit()

        return view
    }
}