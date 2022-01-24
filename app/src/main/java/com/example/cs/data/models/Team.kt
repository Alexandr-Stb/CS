package com.example.cs.data.models

import com.example.cs.data.Storage
import java.io.Serializable

data class Team(
    val id: Int,
    val title: String,
    val logo: Int,
    val players: List<Player>,
    val region: Storage.Regions
): Serializable
