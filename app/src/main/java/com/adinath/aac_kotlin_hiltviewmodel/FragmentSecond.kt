package com.adinath.aac_kotlin_hiltviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.adinath.aac_kotlin_hiltviewmodel.databinding.FragmentSecondBinding

class FragmentSecond : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val sharedViewModel: SharedViewModel by hiltNavGraphViewModels(R.id.main_nav)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.apply {
            idTvSecondFragment.text = sharedViewModel.count.toString()

            idBtnSecondIncrement.setOnClickListener {
                sharedViewModel.increment()
            }

            idBtnSecondFragment.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentSecond_to_fragmentFirst)
            }
        }

        return binding.root
    }

}