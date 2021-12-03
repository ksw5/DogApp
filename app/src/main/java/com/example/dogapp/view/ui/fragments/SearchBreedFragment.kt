package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.dogapp.ApiRequest
import com.example.dogapp.DogApi
import com.example.dogapp.databinding.FragmentSearchBreedBinding
import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.network.DogApiResponse
import com.example.dogapp.retrofit
import com.example.dogapp.utils.hideKeyboard
import com.example.dogapp.viewmodel.DogViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.URI.create


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
            val call = viewModel.apiResponse.value?.status
            if (call == "success") {
                viewModel.getBreed(userSearch.lowercase())
                viewModel.apiResponse.observe(viewLifecycleOwner, {
                    context?.let { it1 ->
                        Glide.with(it1)
                            .load(it.message)
                            .into(binding.searchBreedImage)
                    }
                })
            } else {
                Log.e("Kieran", "Inside of else")
                showError()
            }
            hideKeyboard()
        }
    }

    private fun showError() {
        Snackbar
            .make(
                this.requireContext(),
                binding.userSearch,
                "Woof!! Something's wrong. Try a different breed.",
                Snackbar.LENGTH_SHORT
            )
            .show()
    }
}


