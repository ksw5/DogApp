package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.dogapp.databinding.FragmentPreviousDogBinding
import com.example.dogapp.viewmodel.DogViewModel


class PreviousDogFragment : Fragment() {
    private var _binding: FragmentPreviousDogBinding? = null
    val binding get() = _binding!!
    private val viewModel: DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreviousDogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //callPreviousDogPhoto()
    }

   /* private fun callPreviousDogPhoto() {
        viewModel.showPreviousDogs()
        *//*Glide.with(this)
            .load()
            .into(binding.previousDogImage)*/



}