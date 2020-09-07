package com.desafio.vital.ritaapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.desafio.vital.ritaapp.R
import com.desafio.vital.ritaapp.ui.profile.ProfileFragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonProfile: Button = root.findViewById(R.id.profile)

        buttonProfile.setOnClickListener { // Handler code here.
            val intent = Intent(context, ProfileFragment::class.java);
            startActivity(intent);
        }

        val buttonConsult: Button = root.findViewById(R.id.consults)
        val buttonCare: Button = root.findViewById(R.id.care)
        val buttonTips: Button = root.findViewById(R.id.tips)
        val buttonChatbot: Button = root.findViewById(R.id.chatbot)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }
}