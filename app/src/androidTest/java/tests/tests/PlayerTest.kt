package tests.tests

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.atiurin.ultron.testlifecycle.rulesequence.RuleSequence
import com.atiurin.ultron.testlifecycle.setupteardown.SetUpRule
import com.example.cs.MainActivity
import com.example.cs.TeamContent
import com.example.cs.TeamContent.Companion.TEAM_EXTRA_KEY
import com.example.cs.data.Storage
import com.example.cs.data.getLastTeam
import com.example.cs.data.models.Region
import com.example.cs.data.models.Team
import org.junit.Rule
import org.junit.Test
import tests.screens.DrawerScreen
import tests.screens.PlayerScreen
import tests.screens.TeamsScreen

class PlayerTest {

    companion object {
        private val region: Storage.Regions = Storage.Regions.CIS
        private val lastTeam = getLastTeam(region)
        private val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            TeamContent::class.java
        ).putExtra(TEAM_EXTRA_KEY, lastTeam)
    }

    private val openTeam = SetUpRule()
        .add {
            ActivityScenario.launch<TeamContent>(intent)
        }

    @get:Rule
    val ruleSequence = RuleSequence()

    init {
        ruleSequence.add(openTeam)
    }

    @Test
    fun assertPlayersDisplayed() {
        PlayerScreen.assertPlayerDisplayed(lastTeam)
    }

    @Test
    fun assertDescriptionTeam() {
        PlayerScreen.assertDescriptionDisplayed(lastTeam)
    }


}