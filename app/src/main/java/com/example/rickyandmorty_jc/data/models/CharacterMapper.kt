package com.example.rickyandmorty_jc.data.models

import com.example.CharactersQuery
import com.example.ProfileQuery

fun CharactersQuery.Result.toDomain() = Character(
    id = id,
    name = name,
    image = image,
)

fun ProfileQuery.Character.toDomain() = Character.Profile(
    id = id,
    name = name,
    image = image,
    status = status,
    species = species,
    gender = gender,
    origin = origin?.toDomain(),
    location = location?.toDomain(),
)

fun ProfileQuery.Origin.toDomain() = Character.Origin(
    id = id,
    name = name,
    dimension = dimension
)

fun ProfileQuery.Location.toDomain() = Character.Location(
    id = id,
    name = name,
    dimension = dimension
)