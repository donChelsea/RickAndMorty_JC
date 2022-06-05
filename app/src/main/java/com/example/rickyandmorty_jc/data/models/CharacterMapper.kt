package com.example.rickyandmorty_jc.data.models

import com.example.CharactersQuery

fun CharactersQuery.Result.toDomain() = Character(
    id = id,
    name = name,
    image = image,
)