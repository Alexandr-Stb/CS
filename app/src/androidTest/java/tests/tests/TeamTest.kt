package tests.tests

import tests.screens.TeamsScreen
import androidx.test.rule.ActivityTestRule
import com.atiurin.ultron.testlifecycle.rulesequence.RuleSequence
import com.atiurin.ultron.testlifecycle.setupteardown.SetUp
import com.atiurin.ultron.testlifecycle.setupteardown.SetUpRule
import com.example.cs.MainActivity
import com.example.cs.data.Storage
import com.example.cs.data.getLastTeam
import org.junit.Rule
import org.junit.Test
import tests.framework.DataClass.GAMBIT
import tests.framework.DataClass.LYNN_VISION
import tests.framework.DataClass.VITALITY
import tests.screens.DrawerScreen

class TeamTest {
    companion object {
        private const val CIS = "open CIS region"
        private const val CHINA = "open China region"
        private const val EUROPE = "open Europe region"
    }

    private val activityRule = ActivityTestRule(MainActivity::class.java)

    private val openRegion = SetUpRule()
        .add(CIS) {
            TeamsScreen.openDrawer()
            DrawerScreen.openRegion(Storage.Regions.CIS)
        }
        .add(CHINA) {
            TeamsScreen.openDrawer()
            DrawerScreen.openRegion(Storage.Regions.CHINA)
        }
        .add(EUROPE) {
            TeamsScreen.openDrawer()
            DrawerScreen.openRegion(Storage.Regions.EUROPE)
        }

    @get:Rule
    val ruleSequence = RuleSequence()

    init {
        ruleSequence.add(activityRule,openRegion)
    }

    @SetUp(CIS)
    @Test
    fun teamCisDisplayed() {
        TeamsScreen.assertTeamDisplayed(getLastTeam(Storage.Regions.CIS))
    }
}