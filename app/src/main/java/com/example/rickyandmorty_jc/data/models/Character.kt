package com.example.rickyandmorty_jc.data.models

data class Character(
    val id: String?,
    val name: String?,
    val image: String?,
) {
    data class Profile(
        val id: String?,
        val name: String?,
        val status: String?,
        val species: String?,
        val gender: String?,
        val origin: Origin?,
        val location: Location?,
        val image: String?,
    )

    data class Origin(
        val id: String?,
        val name: String?,
        val dimension: String?,
    )

    data class Location(
        val id: String?,
        val name: String?,
        val dimension: String?,
    )
}
