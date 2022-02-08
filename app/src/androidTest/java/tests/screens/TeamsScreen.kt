package tests.screens

import tests.framework.Screen
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.ultron.core.espresso.recyclerview.UltronRecyclerViewItem
import com.atiurin.ultron.core.espresso.recyclerview.withRecyclerView
import com.atiurin.ultron.custom.espresso.matcher.withDrawable

import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.isDisplayed
import com.example.cs.R
import com.example.cs.data.models.Team
import org.hamcrest.Matchers.allOf

object TeamsScreen : Screen<TeamsScreen> {
    private val recyclerView = withRecyclerView(R.id.recycleView)
    private val burgerBtn = withId(R.id.button_openMenu)
    private val teamItem = withId(R.id.item_full)
    private val titleItem = withId(R.id.text_item)

    fun assertTeamDisplayed(team: Team) {
        getTeamItem(team.title).isDisplayed().click()
        withText(team.players[0].name).isDisplayed()
    }

    fun openDrawer() = apply {
        burgerBtn.click()
        DrawerScreen.assertScreenDisplayed()
    }

    private fun getTeamItem(teamName: String): UltronRecyclerViewItem {
        val matcherItem = allOf(
            teamItem, hasDescendant(
                allOf(titleItem, withText(teamName))
            )
        )

        return recyclerView.item(matcherItem)
    }

    private fun assertIconTeam(team: Team) = apply {
        withDrawable(team.logo).isDisplayed()
    }

    override fun assertScreenDisplayed() {
        teamItem.isDisplayed()
    }
}