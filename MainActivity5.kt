package com.example.tut_bep_android

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var restaurantList = arrayListOf<Restaurant>();

        restaurantList.add(Restaurant(1 , "Rest A" , R.drawable.sampleimg));
        restaurantList.add(Restaurant(2 , "Rest B", R.drawable.food3));
        restaurantList.add(Restaurant(3 , "Rest C" ,R.drawable.food4 ));
        restaurantList.add(Restaurant(4 , "Rest D", R.drawable.food5));
        restaurantList.add(Restaurant(5 , "Rest E" ,R.drawable.food2));

        var restaurantListView = findViewById<RecyclerView>(R.id.restaurant_list)
        restaurantListView.layoutManager = LinearLayoutManager(this)
        restaurantListView.adapter = RestaurantAdapter(this, restaurantList)

    }
}

class RestaurantAdapter(var context: Context, var RestaurantList: ArrayList<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.RestauratViewHolder>(){

    class RestauratViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var restaurantNameTextView = itemView.findViewById<TextView>(R.id.text1)
        var restaurantImg = itemView.findViewById<ImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauratViewHolder {
        val view = LayoutInflater.from(context). inflate(
            R.layout.activity_main4, parent,
            false
        )
        return RestauratViewHolder(view)
    }

    override fun getItemCount(): Int {
        return RestaurantList.size
    }

    override fun onBindViewHolder(holder: RestauratViewHolder, position: Int) {
        var restaurantModel =  RestaurantList.get(position)
        holder.restaurantNameTextView.text = restaurantModel.name
        holder.restaurantImg.setImageResource(restaurantModel.link)
        holder.itemView.setOnClickListener{
            val  intent = Intent(context, MainActivity6::class.java)
            intent.putExtra("name",restaurantModel.name)
            intent.putExtra("img", restaurantModel.link)
            context.startActivity(intent)
        }
    }
}

data class Restaurant(val id: Int, val name: String, val link: Int)