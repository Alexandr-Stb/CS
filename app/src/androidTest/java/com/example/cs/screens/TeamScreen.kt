package com.example.cs.screens

import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.ultron.custom.espresso.matcher.hasAnyDrawable
import com.atiurin.ultron.custom.espresso.matcher.withDrawable
import com.atiurin.ultron.extensions.isDisplayed
import com.atiurin.ultron.extensions.isSuccess
import com.atiurin.ultron.extensions.swipeUp
import com.example.cs.R
import org.hamcrest.Matchers.allOf


object TeamScreen {
    fun assertPageDisplayed()=apply{
        withId(R.id.player_1).isDisplayed()
    }

    fun assertPlayer(nickname: String)=apply {
        if (!withText(nickname).isSuccess { isDisplayed()}) {
            isRoot().swipeUp()
            withText(nickname).isDisplayed()
        }
    }
    fun assertPlayerIcon(avatarId:Int,expectedResourceId:Int){
        allOf(withId(avatarId),withDrawable(expectedResourceId)).isDisplayed()
    }

}