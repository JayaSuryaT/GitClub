package com.digitalcrafts.gitClub.features.splash

import androidx.fragment.app.viewModels
import com.digitalcrafts.gitClub.common.arch.BaseAbsFragment
import com.digitalcrafts.gitClub.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseAbsFragment<SplashViewModel,
        FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override val viewModel: SplashViewModel by viewModels()

    override fun setupViews(): FragmentSplashBinding.() -> Unit = {

        uiScope.launch {
            delay(SPLASH_DELAY)
            SplashFragmentDirections.toRepoList().navigate()
        }
    }

    companion object {

        private const val SPLASH_DELAY: Long = 2 * 1000
    }
}