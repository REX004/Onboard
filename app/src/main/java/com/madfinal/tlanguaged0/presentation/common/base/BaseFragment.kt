package com.madfinal.tlanguaged0.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.util.zip.Inflater

open class BaseFragment<VB : ViewBinding>(private val bindingInflater: (
        inflater: LayoutInflater, container: ViewGroup?, attachBoolean: Boolean) -> VB) : Fragment(
) {

    private var _binding: VB ?= null
    val binding: VB get() = _binding ?: throw IllegalStateException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}