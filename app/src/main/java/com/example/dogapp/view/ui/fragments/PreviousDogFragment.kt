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
import com.example.dogapp.DogApplication
import com.example.dogapp.databinding.FragmentPreviousDogBinding
import com.example.dogapp.view.ui.adapter.DogAdapter
import com.example.dogapp.viewmodel.PreviousViewModel
import com.example.dogapp.viewmodel.PreviousViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



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
}
