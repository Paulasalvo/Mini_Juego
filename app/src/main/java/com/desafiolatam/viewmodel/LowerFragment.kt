package com.desafiolatam.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.FragmentLowerBinding

class LowerFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLowerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLowerBinding.inflate(layoutInflater, container, false)

        lifecycleScope.launchWhenCreated {
            viewModel.counterLowerStateFlow.collect{value->
                binding.tvContadorLower.text = value.toString()

            }
        }

        binding.tvClickLower.setOnClickListener {
            viewModel.increaseLower()
        }
        return binding.root
    }
}