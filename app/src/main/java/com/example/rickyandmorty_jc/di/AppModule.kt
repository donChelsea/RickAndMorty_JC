package com.example.rickyandmorty_jc.di

import com.apollographql.apollo3.ApolloClient
import com.example.rickyandmorty_jc.data.ApolloApiService
import com.example.rickyandmorty_jc.data.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl(ApolloApiService.GRAPHQL_URL)
        .build()

    @Provides
    @Singleton
    fun provideApolloApiService(apolloClient: ApolloClient): ApolloApiService = ApolloApiService(apolloClient)

    @Provides
    @Singleton
    fun provideAppRepository(apiService: ApolloApiService): AppRepository = AppRepository(apiService)

}