package com.example.cs.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.isDisplayed
import com.example.cs.R

object DrawerScreen {
    private val regionsLIst: ViewInteraction = onView(withId(R.id.navigation_view))

    fun assertPageDisplayed(){
        regionsLIst.isDisplayed()
    }
    fun pressToRegion(region:String){
        MainScreen.openDrawer()
        ViewMatchers.withText(region).click()
    }
}