package com.example.rickyandmorty_jc.data

import com.apollographql.apollo3.ApolloClient
import com.example.CharactersQuery
import com.example.ProfileQuery
import javax.inject.Inject

class ApolloApiService @Inject constructor(
    private val apolloClient: ApolloClient
) {

    suspend fun getCharacters(): CharactersQuery.Data? {
        return try {
            apolloClient.query(CharactersQuery()).execute().data
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getProfile(id: String): ProfileQuery.Data? {
        return try {
            apolloClient.query(ProfileQuery(id)).execute().data
        } catch (e: Exception) {
            null
        }
    }

    companion object {
        const val GRAPHQL_URL = "https://rickandmortyapi.com/graphql"
    }
}