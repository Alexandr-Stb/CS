package com.example.cs.data.models

import java.io.Serializable

data class Team(
    val id: Int,
    val title: String,
    val logo: Int,
    val players: List<Player>
): Serializable
