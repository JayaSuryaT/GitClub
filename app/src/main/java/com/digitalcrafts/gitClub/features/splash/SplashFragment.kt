package com.digitalcrafts.gitClub.features.splash

import androidx.fragment.app.viewModels
import com.digitalcrafts.gitClub.common.arch.BaseAbsFragment
import com.digitalcrafts.gitClub.databinding.FragmentSplashBinding


class SplashFragment : BaseAbsFragment<SplashViewModel,
        FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override val viewModel: SplashViewModel by viewModels()
}