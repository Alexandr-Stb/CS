package com.example.cs.data


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import com.example.cs.R
import com.example.cs.data.models.Player
import com.example.cs.data.models.Region
import com.example.cs.data.models.Team
import java.lang.IllegalArgumentException

@SuppressLint("StaticFieldLeak")
object Storage {
    var context: Context? = null
    var teams: List<Team> = listOf(
        Team(
            1, "VIRTUS PRO", R.drawable.virtus, players = listOf(
                Player("Jame", R.drawable.jame_vp),
                Player("Buster", R.drawable.buster_vp),
                Player("Qikert", R.drawable.qikert_vp),
                Player("YEKINDAR", R.drawable.yekindar_vp),
                Player("FL1T", R.drawable.flit_vp)
            ), region = Regions.CIS
        ),
        Team(
            2, "NAVI", R.drawable.navi, players = listOf(
                Player("BoombI4", R.drawable.boom_navi),
                Player("Simple", R.drawable.simple_navi),
                Player("Electronic", R.drawable.electronic_navi),
                Player("Perfecto", R.drawable.perfecto_navi),
                Player("Bit", R.drawable.b1t_navi)
            ), region = Regions.CIS
        ),
        Team(
            3, "GAMBIT", R.drawable.gambit, players = listOf(
                Player("Shiro", R.drawable.shiro_gambit),
                Player("Nafany", R.drawable.nafany_gambit),
                Player("Hobbit", R.drawable.hobbit_gambit),
                Player("Interz", R.drawable.interz_gambit),
                Player("Axile", R.drawable.axile_gambit)
            ), region = Regions.CIS
        ),
        Team(
            4, "TYLOO", R.drawable.tyloo, players = listOf(
                Player("Summer", R.drawable.summer_tyloo),
                Player("Somebody", R.drawable.somebody_tyloo),
                Player("Slowly", R.drawable.slowly_tyloo),
                Player("Danking", R.drawable.danking_tyloo),
                Player("Attacker", R.drawable.attacker_tyloo)
            ), region = Regions.CHINA
        ),
        Team(
            5, "LYNN VISION", R.drawable.lynnvision, players = listOf(
                Player("Expro", R.drawable.expro_lynnvision),
                Player("Bingo", R.drawable.bingo_lynnvision),
                Player("Zakr", R.drawable.zakr_lynnvision),
                Player("Westmelon", R.drawable.westmelon_lynnvision),
                Player("Starry", R.drawable.starry_lynnvision)
            ), region = Regions.CHINA
        ),
        Team(
            6, "VICI", R.drawable.vici, players = listOf(
                Player("Kaze", R.drawable.kaze_vici),
                Player("Jamyoung", R.drawable.jamyoung_vici),
                Player("Advent", R.drawable.advent_vici),
                Player("Auman", R.drawable.auman_vici),
                Player("Zhoking", R.drawable.zhoking_vici)
            ), region = Regions.CHINA
        )
    )

    fun getTeamById(teamId: Int): Team = teams.find { it.id == teamId }
        ?: throw IllegalArgumentException("No team found with id = $teamId")

    val regions by lazy {
        listOf(
            Region(
                Regions.CIS,
                teamIds = listOf(1, 2, 3),
                title = context!!.getString(R.string.CIS)
            ),
            Region(
                Regions.CHINA,
                teamIds = listOf(4, 5, 6),
                title = context!!.getString(R.string.China)
            ),
            Region(
                Regions.EUROPE,
                teamIds = listOf(1, 2),
                title = context!!.getString(R.string.Europe)
            ),
            Region(Regions.USA, teamIds = listOf(1, 2), title = context!!.getString(R.string.USA))
        )
    }

    enum class Regions {
        CIS, CHINA, EUROPE, USA
    }

    fun getRegionTeams(region: Regions): List<Team> {
        val teamIds =
            regions.find { it.regionValue == region }?.teamIds
                ?: emptyList()
        return teams.filter { it.id in teamIds }
    }
}

fun List<Team>.getForRegion(region: Storage.Regions): List<Team> {
    return this.filter { it.region == region }
}