package com.example.rickyandmorty_jc.data.models

import com.example.CharactersQuery
import com.example.ProfileQuery

fun CharactersQuery.Result.toDomain() = Character(
    id = id.toString(),
    name = name.toString(),
    image = image.toString(),
)

fun ProfileQuery.Character.toDomain() = Character.Profile(
    id = id.toString(),
    name = name.toString(),
    image = image.toString(),
    status = status.toString(),
    species = species.toString(),
    gender = gender.toString(),
    origin = origin?.toDomain(),
    location = location?.toDomain(),
)

fun ProfileQuery.Origin.toDomain() = Character.Origin(
    id = id.toString(),
    name = name.toString(),
    dimension = dimension.toString()
)

fun ProfileQuery.Location.toDomain() = Character.Location(
    id = id.toString(),
    name = name.toString(),
    dimension = dimension.toString()
)