package com.example.cs.data

import android.content.Context
import com.example.cs.R
import com.example.cs.data.models.Player
import com.example.cs.data.models.Region
import com.example.cs.data.models.Team
import java.lang.IllegalArgumentException

object Storage {
    var teams: List<Team> = listOf(
        Team(1, "VIRTUS PRO", R.drawable.virtus, players = listOf(
            Player("Jame", R.drawable.jame_vp),
            Player("Buster", R.drawable.buster_vp),
            Player("Qikert", R.drawable.qikert_vp),
            Player("YEKINDAR", R.drawable.yekindar_vp),
            Player("FL1T", R.drawable.flit_vp)
        ))  ,
        Team(2, "Navi", R.drawable.navi, players = listOf(
            Player("BoombI4", R.drawable.boom_navi),
            Player("Simple", R.drawable.simple_navi),
            Player("Electronic", R.drawable.electronic_navi),
            Player("Perfecto", R.drawable.perfecto_navi),
            Player("Bit", R.drawable.b1t_navi)
        )),
        Team(3, "Goat", R.drawable.navi, players = listOf(
            Player("BoombI4", R.drawable.boom_navi),
            Player("Simple", R.drawable.simple_navi),
            Player("Electronic", R.drawable.electronic_navi),
            Player("Perfecto", R.drawable.perfecto_navi),
            Player("Bit", R.drawable.b1t_navi)
        ))

    )

    fun getTeamById(teamId: Int): Team = teams.find { it.id == teamId } ?: throw IllegalArgumentException("No team found with id = $teamId")

    val regions = listOf<Region>(
        Region(Regions.CIS, teamIds = listOf(1,2,3)),
        Region(Regions.CHINA, teamIds = listOf(1,2)),
        Region(Regions.EUROPE, teamIds = listOf(1,2)),
        Region(Regions.USA, teamIds = listOf(1,2))
    )

    enum class Regions {
        CIS, CHINA, EUROPE, USA
    }

    fun getTeamIdsForRegion(region: Regions) = regions.find { it.title == region }!!.teamIds
    fun getTeamsForRegion(region: Regions) = getTeamIdsForRegion(region).map { teamId -> getTeamById(teamId) }
}