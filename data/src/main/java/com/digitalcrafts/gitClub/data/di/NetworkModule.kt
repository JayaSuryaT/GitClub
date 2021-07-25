package com.digitalcrafts.gitClub.data.di

import com.digitalcrafts.gitClub.data.internal.data.network.definitons.NetworkClient
import com.digitalcrafts.gitClub.data.internal.data.network.impl.NetworkClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class NetworkModule {

    @Binds
    internal abstract fun getNetworkClient(impl: NetworkClientImpl): NetworkClient
}