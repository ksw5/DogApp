package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.dogapp.DogApplication
import com.example.dogapp.R
import com.example.dogapp.databinding.FragmentPreviousDogBinding
import com.example.dogapp.model.data.Dog
import com.example.dogapp.view.ui.MainActivity
import com.example.dogapp.view.ui.OnDogClickListener
import com.example.dogapp.view.ui.adapter.DogAdapter
import com.example.dogapp.viewmodel.DogViewModel
import com.example.dogapp.viewmodel.DogViewModelFactory
import com.example.dogapp.viewmodel.PreviousViewModel
import com.example.dogapp.viewmodel.PreviousViewModelFactory
import kotlinx.android.synthetic.main.previous_dog_item.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import java.net.URL


class PreviousDogFragment : Fragment() {

    private var _binding: FragmentPreviousDogBinding? = null
    val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    val dogAdapter = DogAdapter()

    val viewModel: PreviousViewModel by activityViewModels() {
        PreviousViewModelFactory((activity?.application as DogApplication).database.dogDao())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreviousDogBinding.inflate(inflater, container, false)
        val view = binding.root
        observeViewModel(dogAdapter)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.previousDogRv
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = dogAdapter


        lifecycle.coroutineScope.launch {
            viewModel.showPreviousDogs().collect() {
                dogAdapter.submitList(it)
            }
        }


    }

    private fun observeViewModel(dogAdapter: DogAdapter) {
        viewModel.previousDogs.observe(viewLifecycleOwner) {
            dogAdapter.submitList(it)
        }
    }





}
