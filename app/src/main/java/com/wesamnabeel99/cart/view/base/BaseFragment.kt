package com.wesamnabeel99.cart.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter> : Fragment() {
    private lateinit var _binding: ViewBinding
    protected val binding: VB
        get() = _binding as VB

    private lateinit var _presenter: BasePresenter
    protected val presenter: P
        get() = _presenter as P

    abstract val presenterType: BasePresenter
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(layoutInflater, container, false)
        _presenter = presenterType
        return binding.root
    }

}