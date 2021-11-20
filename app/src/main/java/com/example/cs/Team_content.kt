package com.example.cs

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.team_player.*
import java.sql.Array

class Team_content:AppCompatActivity() {
    companion object{
        const val TEAM_EXTRA_KEY="team"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_player)
        var team = intent.getStringExtra(TEAM_EXTRA_KEY)
        if (team == "NAVI") {
            draw_team(getImageId(R.array.navi_img),resources.getStringArray(R.array.navi_team))
        } else if(team=="VIRTUS PRO"){
            draw_team(getImageId(R.array.vp_img),resources.getStringArray(R.array.vp_team))
        }else if(team=="GAMBIT"){
            draw_team(getImageId(R.array.gambit_img),resources.getStringArray(R.array.gambit_team))
        }else if(team=="TYLOO"){
            draw_team(getImageId(R.array.tyloo_img),resources.getStringArray(R.array.tyloo_team))
        }else if(team=="LYNN VISION"){
            draw_team(getImageId(R.array.lynnVision_img),resources.getStringArray(R.array.lynnVision_team))
        }else if(team=="VICI"){
            draw_team(getImageId(R.array.vici_img),resources.getStringArray(R.array.vici_team))
        }


    }


    private fun draw_team(arrayImg:IntArray,arrayTitle:kotlin.Array<String>){
            player_1.setImageResource(arrayImg[0])
            player_2.setImageResource(arrayImg[1])
            player_3.setImageResource(arrayImg[2])
            player_4.setImageResource(arrayImg[3])
            player_5.setImageResource(arrayImg[4])

            title_player_1.text = arrayTitle[0]
            title_player_2.text = arrayTitle[1]
            title_player_3.text = arrayTitle[2]
            title_player_4.text = arrayTitle[3]
            title_player_5.text = arrayTitle[4]
    }

    private fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids


    }
}




