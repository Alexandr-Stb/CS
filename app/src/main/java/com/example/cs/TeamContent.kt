package com.example.cs

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cs.data.models.Player
import com.example.cs.data.models.Team
import kotlinx.android.synthetic.main.team_player.*
import java.sql.Array

class TeamContent:AppCompatActivity() {
    companion object{
        const val TEAM_EXTRA_KEY="team"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_player)
        var team = intent.getSerializableExtra(TEAM_EXTRA_KEY) as Team
        draw_team(team.players)
//        if (team == "NAVI") {
//            draw_team(getImageId(R.array.navi_img),resources.getStringArray(R.array.navi_team))
//        } else if(team=="VIRTUS PRO"){
//            draw_team(getImageId(R.array.vp_img),resources.getStringArray(R.array.vp_team))
//        }else if(team=="GAMBIT"){
//            draw_team(getImageId(R.array.gambit_img),resources.getStringArray(R.array.gambit_team))
//        }else if(team=="TYLOO"){
//            draw_team(getImageId(R.array.tyloo_img),resources.getStringArray(R.array.tyloo_team))
//        }else if(team=="LYNN VISION"){
//            draw_team(getImageId(R.array.lynnVision_img),resources.getStringArray(R.array.lynnVision_team))
//        }else if(team=="VICI"){
//            draw_team(getImageId(R.array.vici_img),resources.getStringArray(R.array.vici_team))
//        }


    }


    private fun draw_team(players: List<Player>){
            player_1.setImageResource(players[0].avatar)
            player_2.setImageResource(players[1].avatar)
            player_3.setImageResource(players[2].avatar)
            player_4.setImageResource(players[3].avatar)
            player_5.setImageResource(players[4].avatar)

            title_player_1.text = players[0].name
            title_player_2.text = players[1].name
            title_player_3.text = players[2].name
            title_player_4.text = players[3].name
            title_player_5.text = players[4].name
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




