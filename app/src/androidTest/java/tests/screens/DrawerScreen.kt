package tests.screens

import android.graphics.Region
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.isDisplayed
import com.example.cs.R
import com.example.cs.data.Storage
import tests.framework.Screen

object DrawerScreen: Screen<DrawerScreen> {
    private val titleDrawer = withId(R.id.textView)

    fun openRegion(region: Storage.Regions){
        withText(Storage.regions.find{it.regionValue == region}?.title).click()
    }

    override fun assertScreenDisplayed() {
        titleDrawer.isDisplayed()
    }
}