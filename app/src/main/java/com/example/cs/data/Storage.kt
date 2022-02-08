package com.example.cs.data


import android.annotation.SuppressLint
import android.content.Context
import com.example.cs.R
import com.example.cs.data.models.DataClass.ASTRALIS_DESCRIPTION
import com.example.cs.data.models.DataClass.FNATIC_DESCRIPTION
import com.example.cs.data.models.DataClass.GAMBIT_DESCRIPTION
import com.example.cs.data.models.DataClass.LYNN_DESCRIPTION
import com.example.cs.data.models.DataClass.NAVI_DESCRIPTION
import com.example.cs.data.models.DataClass.TYLOO_DESCRIPTION
import com.example.cs.data.models.DataClass.VICI_DESCRIPTION
import com.example.cs.data.models.DataClass.VITALITY_DESCRIPTION
import com.example.cs.data.models.DataClass.VP_DESCRIPTION
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
            ), region = Regions.CIS,VP_DESCRIPTION,R.drawable.vp_back
        ),
        Team(
            2, "NAVI", R.drawable.navi, players = listOf(
                Player("BoombI4", R.drawable.boom_navi),
                Player("S1mple", R.drawable.simple_navi),
                Player("Electronic", R.drawable.electronic_navi),
                Player("Perfecto", R.drawable.perfecto_navi),
                Player("B1t", R.drawable.b1t_navi)
            ), region = Regions.CIS, NAVI_DESCRIPTION,R.drawable.navi_back
        ),
        Team(
            3, "GAMBIT", R.drawable.gambit, players = listOf(
                Player("Shiro", R.drawable.shiro_gambit),
                Player("Nafany", R.drawable.nafany_gambit),
                Player("Hobbit", R.drawable.hobbit_gambit),
                Player("Interz", R.drawable.interz_gambit),
                Player("Axile", R.drawable.axile_gambit)
            ), region = Regions.CIS,GAMBIT_DESCRIPTION,R.drawable.gambit_back
        ),
        Team(
            4, "TYLOO", R.drawable.tyloo, players = listOf(
                Player("Summer", R.drawable.summer_tyloo),
                Player("Somebody", R.drawable.somebody_tyloo),
                Player("Slowly", R.drawable.slowly_tyloo),
                Player("Danking", R.drawable.danking_tyloo),
                Player("Attacker", R.drawable.attacker_tyloo)
            ), region = Regions.CHINA, TYLOO_DESCRIPTION,R.drawable.tyloo_back
        ),
        Team(
            5, "LYNN VISION", R.drawable.lynnvision, players = listOf(
                Player("Expro", R.drawable.expro_lynnvision),
                Player("Bingo", R.drawable.bingo_lynnvision),
                Player("Zakr", R.drawable.zakr_lynnvision),
                Player("Westmelon", R.drawable.westmelon_lynnvision),
                Player("Starry", R.drawable.starry_lynnvision)
            ), region = Regions.CHINA, LYNN_DESCRIPTION,R.drawable.lynnvision_back
        ),
        Team(
            6, "VICI", R.drawable.vici, players = listOf(
                Player("Kaze", R.drawable.kaze_vici),
                Player("Jamyoung", R.drawable.jamyoung_vici),
                Player("Advent", R.drawable.advent_vici),
                Player("Auman", R.drawable.auman_vici),
                Player("Zhoking", R.drawable.zhoking_vici)
            ), region = Regions.CHINA, VICI_DESCRIPTION,R.drawable.vici_back
        ),
        Team(
            7, "ASTRALIS", R.drawable.astralis, players = listOf(
                Player("blameF", R.drawable.astralis_blamef),
                Player("Xyp9x", R.drawable.astralis_xypx),
                Player("Lucky", R.drawable.astralis_lucky),
                Player("gla1ve", R.drawable.astralis_glaive),
                Player("k0nfig", R.drawable.astralis_konfig)
            ), region = Regions.EUROPE, ASTRALIS_DESCRIPTION,R.drawable.astralis_back
        ),
        Team(
            8, "FNATIC", R.drawable.fnatic, players = listOf(
                Player("CRIMZ", R.drawable.fnatic_crimz),
                Player("ALEX", R.drawable.fnatic_alex),
                Player("Brollan", R.drawable.fnatic_brollan),
                Player("Mezii", R.drawable.fnatic_mezii),
                Player("smooya", R.drawable.fnatic_smooya)
            ), region = Regions.EUROPE, FNATIC_DESCRIPTION,R.drawable.fnatic_back
        ),
        Team(
            9, "VITALITY", R.drawable.vitality, players = listOf(
                Player("ZywOo", R.drawable.vitality_zywoo),
                Player("apEX", R.drawable.vitality_apex),
                Player("dupreeh", R.drawable.vitality_dupreeh),
                Player("Kyojin", R.drawable.vitality_kyojin),
                Player("misutaaa", R.drawable.vitality_misutaa)
            ), region = Regions.EUROPE, VITALITY_DESCRIPTION,R.drawable.vitality_back
        ),


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
                teamIds = listOf(7,8,9),
                title = context!!.getString(R.string.Europe)
            ),
        )
    }

    enum class Regions {
        CIS, CHINA, EUROPE
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

fun getLastTeam(region: Storage.Regions):Team{
    return Storage.teams.find{it.id == Storage.regions.find{it.regionValue == region}?.teamIds?.last()}!!
}

