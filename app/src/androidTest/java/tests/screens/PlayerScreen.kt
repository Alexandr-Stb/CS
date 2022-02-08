package tests.screens

import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.ultron.custom.espresso.matcher.withDrawable
import com.atiurin.ultron.extensions.isDisplayed
import com.atiurin.ultron.extensions.swipeUp
import com.example.cs.R
import com.example.cs.data.models.Team
import org.hamcrest.Matchers.allOf
import tests.framework.Screen


object PlayerScreen: Screen<PlayerScreen> {
    private val firstPlayer = withId(R.id.player_1)
    private val titleFirstPlayer = withId(R.id.title_player_1)
    private val description = withId(R.id.textDescription)
    private val linearLayout = withId(R.id.teamPlayer)

    fun assertPlayerDisplayed(team:Team){
        allOf(titleFirstPlayer, withText(team.players[0].name)).isDisplayed()
    }

    fun assertDescriptionDisplayed(team: Team){
        isRoot().swipeUp()
        allOf(description, withText(team.description)).isDisplayed()
    }

    override fun assertScreenDisplayed() {
        firstPlayer.isDisplayed()
    }
}