package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.dogapp.databinding.FragmentSearchBreedBinding
import com.example.dogapp.utils.hideKeyboard
import com.example.dogapp.viewmodel.DogViewModel


class SearchBreedFragment : Fragment() {
    private var _binding: FragmentSearchBreedBinding? = null
    val binding get() = _binding!!
    private val viewModel: DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBreedBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        breedImage()
        
    }

    private fun breedImage() {
        binding.searchBreedBtn.setOnClickListener {
            val userSearch = binding.userSearch.text.toString()
            viewModel.getBreed(userSearch.lowercase())
            viewModel.apiResponse.observe(viewLifecycleOwner, {
                Glide.with(this)
                    .load(it.message)
                    .into(binding.imageViewSearch)
            })
            hideKeyboard()
        }
    }
}