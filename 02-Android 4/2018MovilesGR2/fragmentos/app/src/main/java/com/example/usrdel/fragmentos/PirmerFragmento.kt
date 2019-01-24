package com.example.usrdel.fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup





class PirmerFragmento : Fragment() {
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("fragmentos","on attach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pirmer_fragmento, container, false)
    }
}
