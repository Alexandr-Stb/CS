package tests.tests

import androidx.test.rule.ActivityTestRule
import com.atiurin.ultron.testlifecycle.rulesequence.RuleSequence
import com.atiurin.ultron.testlifecycle.setupteardown.SetUp
import com.atiurin.ultron.testlifecycle.setupteardown.SetUpRule
import com.example.cs.MainActivity
import com.example.cs.data.Storage
import org.junit.Rule
import org.junit.Test
import tests.screens.DrawerScreen
import tests.screens.TeamsScreen

class DrawerTest {
    companion object {
        private val region = Storage.Regions.EUROPE
    }

    private val activityRule = ActivityTestRule(MainActivity::class.java)

    private val openDrawer = SetUpRule()
        .add { TeamsScreen.openDrawer() }

    @get:Rule
    val ruleSequence = RuleSequence()

    init {
        ruleSequence.add(activityRule, openDrawer)
    }

    @SetUp
    @Test
    fun assertRegion() {
        DrawerScreen.openRegion(region)
    }
}