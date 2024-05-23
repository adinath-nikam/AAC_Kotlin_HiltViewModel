package com.adinath.aac_kotlin_hiltviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.adinath.aac_kotlin_hiltviewmodel.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFirst : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val viewModel: SharedViewModel by hiltNavGraphViewModels(R.id.main_nav)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.apply {

            idTvFirstFragment.text = viewModel.count.toString();

            idBtnFirstIncrement.setOnClickListener {
                viewModel.increment()
            }

            idBtnFirstFragment.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentFirst_to_fragmentSecond)
            }
        }


        return binding.root
    }
}