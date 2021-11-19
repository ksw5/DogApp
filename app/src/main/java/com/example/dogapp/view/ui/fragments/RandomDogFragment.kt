package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.dogapp.databinding.FragmentRandomDogBinding
import com.example.dogapp.viewmodel.DogViewModel

class RandomDogFragment : Fragment() {
    private var _binding: FragmentRandomDogBinding? = null
    val binding get() = _binding!!
    private val viewModel: DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomDogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callDogPhoto()

        binding.randomButton.setOnClickListener {
            viewModel.getNewDog()
            binding.randomDogImage.visibility = View.GONE
        }

        binding.searchFab.setOnClickListener {
            findNavController().navigate(RandomDogFragmentDirections.actionRandomDogFragmentToSearchBreedFragment())
        }

        binding.previousFab.setOnClickListener {
            findNavController().navigate(RandomDogFragmentDirections.actionRandomDogFragmentToPreviousDogFragment())
        }
    }

    private fun callDogPhoto() {
        viewModel.apiResponse.observe(viewLifecycleOwner, {
            Glide.with(this)
                .load(it.message)
                .into(binding.randomDogImage)
            binding.randomDogImage.visibility = View.VISIBLE
        })
    }
}




