package com.example.richard.oichina.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.richard.oichina.R

/**
 * Created by Richard on 9/23/2018.
 */

class FragmentBasic : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.basic_fragment, container, false)
    }
}
