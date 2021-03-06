package com.digitalcrafts.gitClub.common.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseAbsFragment<V : BaseViewModel, B : ViewBinding>(
    private val viewInflater: (LayoutInflater) -> B
) : BaseFragment() {

    abstract val viewModel: V

    @Suppress("MemberVisibilityCanBePrivate")
    protected var nullableBinding: B? = null

    @Suppress("MemberVisibilityCanBePrivate")
    protected val binding: B
        get() = nullableBinding
            ?: throw IllegalStateException("View either has not been initialized or has been destroyed")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nullableBinding = viewInflater(inflater)
        setupViews().invoke(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers().invoke(viewModel)
    }

    open fun setupViews(): B.() -> Unit = {}
    open fun setupObservers(): V.() -> Unit = {}

    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }
}