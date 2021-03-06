package com.desafio.vital.ritaapp.ui.bot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.desafio.vital.ritaapp.R
import com.tyagiabhinav.dialogflowchatlibrary.Chatbot
import com.tyagiabhinav.dialogflowchatlibrary.ChatbotActivity
import com.tyagiabhinav.dialogflowchatlibrary.ChatbotSettings
import com.tyagiabhinav.dialogflowchatlibrary.DialogflowCredentials
import java.util.*


class BotFragment : Fragment() {

    private lateinit var botViewModel: BotViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        botViewModel =
            ViewModelProviders.of(this).get(BotViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bot, container, false)

        openChatbot(view)
        return root
    }

    fun openChatbot(view: View?) {
        // provide your Dialogflow's Google Credential JSON saved under RAW folder in resources
        DialogflowCredentials.getInstance()
            .setInputStream(resources.openRawResource(R.raw.dialogflow_credentials))
        ChatbotSettings.getInstance().chatbot =
            Chatbot.ChatbotBuilder()
                .build()
        val intent =
            android.content.Intent(context, ChatbotActivity::class.java)
        val bundle = Bundle()

        // provide a UUID for your session with the Dialogflow agent
        bundle.putString(ChatbotActivity.SESSION_ID, UUID.randomUUID().toString())
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

