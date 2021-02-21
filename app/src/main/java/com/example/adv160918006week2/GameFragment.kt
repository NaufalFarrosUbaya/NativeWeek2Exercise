package com.example.adv160918006week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var playerScore = 0

        var a =(1..99).random()
        var b = (1..99).random()

        var result = a+b

        txtRanNum1.text="$a"
        txtRanNum2.text="$b"

        if(arguments != null){
            val playerName=GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text="$playerName's Turn"
        }

        btnSubmitAnswer.setOnClickListener {
            var answer = Integer.parseInt(txtAnswer.text.toString())

            if(answer==result){
                playerScore+=1

                a = (1..9).random()
                b = (1..9).random()

                txtRanNum1.text = "$a"
                txtRanNum2.text = "$b"

                result=a+b
            }
            else
            {
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}