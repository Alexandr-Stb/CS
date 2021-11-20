package com.example.cs

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_menu.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MyAdapter(listArray: ArrayList<ListItem>,context:Context,segment: String):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context
    var segment = segment
    class ViewHolder (view: View):RecyclerView.ViewHolder(view) {
        val titleItem = view.findViewById<TextView>(R.id.text_item)
        val image = view.findViewById<ImageView>(R.id.image_item)
        fun bind(listItem: ListItem, context: Context,segment: String) {
            titleItem.text = listItem.title
            image.setImageResource(listItem.imgId)
            itemView.setOnClickListener {
                var team = this.itemView.item_full.text_item.text
                context.startActivity(this.transfer(team,context))
            }
        }

        private fun transfer(team: CharSequence?, context: Context): Intent{
            var i = Intent(context, Team_content::class.java)
            i.putExtra(Team_content.TEAM_EXTRA_KEY, team)
//            if (team == "NAVI"){
//                i.apply {
//                    putExtra(Team_content.TEAM_EXTRA_KEY,"NAVI")
//                }
//            } else if (team == "VIRTUS PRO"){
//                i.apply {
//                    putExtra("team","VP")
//                }
//            }else if (team == "GAMBIT"){
//                i.apply {
//                    putExtra("team","GAMBIT")
//                }
//            }else if (team == "TYLOO"){
//                i.apply {
//                    putExtra("team","TYLOO")
//                }
//            }else if (team == "LYNN VISION"){
//                i.apply {
//                    putExtra("team","LYNN VISION")
//                }
//            }else if (team == "VICI"){
//                i.apply {
//                    putExtra("team","VICI")
//                }
//            }
            return i

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR,this.segment)

    }


    override fun getItemCount(): Int {
        return  listArrayR.size
    }

    fun updateAdapter(listArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}