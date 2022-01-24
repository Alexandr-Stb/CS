package com.example.cs.tests

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cs.R
import com.example.cs.TeamContent
import com.example.cs.data.Storage
import com.example.cs.data.models.Team
import com.example.cs.screens.TeamScreen
import org.junit.Before
import org.junit.Test

class TeamScreenTest {
    val team = Storage.teams[5]

    @Before
    fun launchActivity(){
        ActivityScenario.launch<TeamContent>(prepareIntent(team, InstrumentationRegistry.getInstrumentation().targetContext))
    }
    @Test
    fun checkPlayer(){
        TeamScreen.assertPlayer(team.players[4].name)
    }
    private fun prepareIntent(team: Team, context: Context): Intent {
        var i = Intent(context, TeamContent::class.java)
        i.putExtra(TeamContent.TEAM_EXTRA_KEY,team)
        return i
    }
    @Test

    fun assetPlayerAvatar(){
        TeamScreen.assertPlayerIcon(R.id.player_3,R.drawable.advent_vici)
    }
}