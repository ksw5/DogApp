package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogapp.DogApplication
import com.example.dogapp.databinding.FragmentPreviousDogBinding
import com.example.dogapp.model.repository.DogRepository
import com.example.dogapp.view.ui.MainActivity
import com.example.dogapp.viewmodel.DogViewModel
import com.example.dogapp.viewmodel.DogViewModelFactory


class PreviousDogFragment : Fragment() {
    private var _binding: FragmentPreviousDogBinding? = null
    val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: DogViewModel

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
        viewModel = (activity as MainActivity).viewModel
        //callPreviousDogPhoto()
    }

   /*private fun callPreviousDogPhoto() {
       viewModel.apiResponse.observe(viewLifecycleOwner, {
           Glide.with(this)
               .load(it.message)
               .into(binding.previousDogRv)
       })
   }*/



    // show last image
    //length of list - 1



}