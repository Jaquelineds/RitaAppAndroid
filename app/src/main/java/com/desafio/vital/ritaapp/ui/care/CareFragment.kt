package com.desafio.vital.ritaapp.ui.care

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.desafio.vital.ritaapp.R

class CareFragment : Fragment() {

    private lateinit var careViewModel: CareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        careViewModel =
            ViewModelProviders.of(this).get(CareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_care, container, false)
        val textView: TextView = root.findViewById(R.id.text_care)
        careViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}