package com.desafio.vital.ritaapp.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.desafio.vital.ritaapp.R

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val textView: TextView = root.findViewById(R.id.text_name)
        profileViewModel.textName.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val textAccount: TextView = root.findViewById((R.id.text_accountType))
        profileViewModel.textAccount.observe(viewLifecycleOwner, Observer {
            textAccount.text = it
        })
        return root
    }
}