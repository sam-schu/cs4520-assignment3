package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.HomeFragmentBinding

/**
 * The fragment for the home screen of the app that allows the user to select the MVP calculator
 * implementation or the MVVM calculator implementation.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeFragmentBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mvpButton.setOnClickListener(::mvpButtonClicked)
        binding.mvvmButton.setOnClickListener(::mvvmButtonClicked)
    }

    private fun mvpButtonClicked(v: View?) {
        HomeFragmentDirections.actionHomeFragmentToMvpFragment().let {
            findNavController().navigate(it)
        }
    }

    private fun mvvmButtonClicked(v: View?) {
        HomeFragmentDirections.actionHomeFragmentToMvvmFragment().let {
            findNavController().navigate(it)
        }
    }
}