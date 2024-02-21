package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpFragmentBinding

/**
 * The fragment to display the MVP (model-view-presenter) implementation of the calculator.
 */
class MVPFragment : Fragment() {
    private lateinit var binding: MvpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MvpFragmentBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}