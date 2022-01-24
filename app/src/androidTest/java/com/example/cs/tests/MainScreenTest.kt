package com.example.cs.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.cs.screens.DrawerScreen
import com.example.cs.MainActivity
import com.example.cs.data.Storage
import com.example.cs.data.models.Region
import com.example.cs.screens.MainScreen
import com.example.cs.screens.TeamScreen
import org.junit.Rule
import org.junit.Test


class MainScreenTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstTest() {
        MainScreen.openTeam("VICI", "China")
        TeamScreen.assertPlayer("Kaze")

    }
    @Test
    fun drawerTest(){
        val team = Storage.teams[5]
        val region = Storage.regions.find { it.regionValue == team.region }!!
        MainScreen.openDrawer()
        DrawerScreen.pressToRegion(region.title)
        MainScreen.assertTeamDisplayed(team.title)
    }

}