package com.example.cs

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cs.data.models.Player
import com.example.cs.data.models.Team
import kotlinx.android.synthetic.main.team_player.*

class TeamContent : AppCompatActivity() {
    companion object {
        const val TEAM_EXTRA_KEY = "team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_player)
        var team = intent.getSerializableExtra(TEAM_EXTRA_KEY) as Team
        drawTeam(team.players, team)
    }


    private fun drawTeam(players: List<Player>, team: Team) {
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

        textDescription.text = team.description
        teamPlayer.setBackgroundResource(team.background)

    }

}




