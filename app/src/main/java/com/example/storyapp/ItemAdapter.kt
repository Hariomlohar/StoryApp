package com.example.storyapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(val storytitles:Array<String>, val story_contant:Array<String>, val story_image:Array<String>) :RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardimage: ImageView = itemView.findViewById(R.id.cardimage)
        val cardtitle : TextView = itemView.findViewById(R.id.Card_title)
        val cardcontent : TextView = itemView.findViewById(R.id.cardcontant)
        val view = itemView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.costem_item_view,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardtitle.text = storytitles[position]
        holder.cardcontent.text= story_contant[position]
        Picasso.get().load(story_image[position]).into(holder.cardimage)

        holder.view.setOnClickListener{
           // Toast.makeText(holder.view.context,"Item number ->"+ position,Toast.LENGTH_SHORT)
            val intent = Intent(it.context,Details::class.java)
            intent.putExtra("storytitle",storytitles[position])
            intent.putExtra("storycontant",story_contant[position])
            intent.putExtra("storyimage",story_image[position])
            holder.view.context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return storytitles.size
    }
}







