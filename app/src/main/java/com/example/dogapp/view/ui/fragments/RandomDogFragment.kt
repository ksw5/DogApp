package com.example.dogapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.dogapp.DogApplication
import com.example.dogapp.databinding.FragmentRandomDogBinding
import com.example.dogapp.viewmodel.DogViewModel
import com.example.dogapp.viewmodel.DogViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RandomDogFragment : Fragment() {
    private var _binding: FragmentRandomDogBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel : DogViewModel
    private lateinit var factory: DogViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomDogBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(requireParentFragment(), factory).get(DogViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callDogPhoto()

        binding.randomButton.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getNewDog()
                binding.randomDogImage.visibility = View.GONE
                /*var dogs = Array<DogApiResponse>(message)
                val message = Array<DogApiResponse>().message*/

            }

        }

        /*fun saveDogs(dogs: Array<DogApiResponse>) {
            var items = ArrayList<Dog>()
            for (dog in dogs) {
                val item = Dog
                item.url = dog.message
            }
        }*/
        /*lifecycleScope.launch {
            val message = DogApiResponse("message").toString()
            val dog = Dog(id = 0, url = message)
            viewModel.addPreviousDog(dog)
        }*/

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




