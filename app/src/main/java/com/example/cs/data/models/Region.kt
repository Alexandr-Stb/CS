package com.example.cs.data.models

import com.example.cs.data.Storage

data class Region(
    val regionValue: Storage.Regions,
    val teamIds: List<Int>,
    val title:String
)
