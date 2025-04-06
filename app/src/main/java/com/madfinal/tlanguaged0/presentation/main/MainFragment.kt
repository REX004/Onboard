package com.madfinal.tlanguaged0.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.madfinal.tlanguaged0.databinding.FragmentMainBinding
import com.madfinal.tlanguaged0.presentation.common.UiState
import com.madfinal.tlanguaged0.presentation.main.adapters.TopUsersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private val adapter: TopUsersAdapter by lazy { TopUsersAdapter(requireContext()) }

    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAdapter()
        observeViewModel()
        viewModel.getTopUsers()
    }


    private fun observeAdapter() {
        binding.topUsersRv.apply {
            adapter = this@MainFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.topUsers.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Error -> {

                }

                is UiState.Loading -> {

                }

                is UiState.Success -> {
                    adapter.submitList(state.data)
                }
            }
        }
    }
}