package com.example.cs.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.ultron.core.espresso.recyclerview.UltronRecyclerViewItem
import com.atiurin.ultron.core.espresso.recyclerview.withRecyclerView
import com.atiurin.ultron.extensions.click
import com.example.cs.R
import org.hamcrest.Matchers.allOf

object MainScreen {
    private val openMenuButton = onView(withId(R.id.button_openMenu))
    private val recyclerView = withRecyclerView(R.id.recykleView)

    fun openDrawer() {
        openMenuButton.click()
        DrawerScreen.assertPageDisplayed()
    }

    fun openTeam(name: String, region: String): TeamScreen {
        openDrawer()
        DrawerScreen.pressToRegion(region)
        getRecyclerItem(name).click()
        return TeamScreen.assertPageDisplayed()
    }

    fun assertTeamDisplayed(teamName: String) {
        getRecyclerItem(teamName).isDisplayed()
    }

    private fun getRecyclerItem(teamName: String): UltronRecyclerViewItem {
        val itemMatcher = allOf(
            withId(R.id.item_full),
            hasDescendant(allOf(withId(R.id.text_item), withText(teamName)))
        )
        return recyclerView.item(itemMatcher)
    }



}