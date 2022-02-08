package com.example.cs

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.data.Storage
import com.example.cs.data.models.Team

class MyAdapter(teams: List<Team>,val context:Context):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var teams: List<Team> = mutableListOf()
    class ViewHolder (view: View):RecyclerView.ViewHolder(view) {
        val titleItem = view.findViewById<TextView>(R.id.text_item)
        val image = view.findViewById<ImageView>(R.id.image_item)
        fun bind(team: Team, context: Context) {
            titleItem.text = team.title
            image.setImageResource(team.logo)
            itemView.setOnClickListener {
//                var team = Storage.teams[position]
                context.startActivity(this.transfer(team,context))
            }
        }

        private fun transfer(team: Team, context: Context): Intent{
            var i = Intent(context, TeamContent::class.java)
            i.putExtra(TeamContent.TEAM_EXTRA_KEY,team)
            return i
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind( teams[position], context)

    }


    override fun getItemCount(): Int {
        return  teams.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(teams: List<Team>){
        this.teams = teams


        notifyDataSetChanged()
    }
}