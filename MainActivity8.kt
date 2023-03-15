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
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.helper.AppHelper
import com.example.tut_bep_android.api.ApiInterface
import com.example.tut_bep_android.api.RetrofitClient
import com.example.tut_bep_android.models.AllUsersInfo
import com.example.tut_bep_android.models.DataItem
import com.google.gson.Gson
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity8 : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var apiInterface: ApiInterface
    lateinit var sampleListView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        initData()

        getAllUserInfo()

    }

    class sampleAdapter(var context: Context, var sampleList: ArrayList<DataItem>) : RecyclerView.Adapter<sampleAdapter.sampleViewHolder>() {

        class sampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var NameTextView = itemView.findViewById<TextView>(R.id.name)
            var Img = itemView.findViewById<ImageView>(R.id.img)
            var emailTextView = itemView.findViewById<TextView>(R.id.email)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sampleViewHolder {
            val view = LayoutInflater.from(context).inflate(
                R.layout.card, parent,
                false
            )
            return sampleViewHolder(view)
        }

        override fun getItemCount(): Int {
            return sampleList.size
        }

        override fun onBindViewHolder(holder: sampleViewHolder, position: Int) {
            var sampleModel = sampleList.get(position)
            holder.NameTextView.text = sampleModel.firstName + sampleModel.lastName

            Glide
                .with(context)
                .load(sampleModel.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.Img)

            holder.emailTextView.text = sampleModel.email
        }
    }

        private fun initData() {
        retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    private fun getAllUserInfo() {

        if (AppHelper.isConnected(this)) {

            apiInterface.getAllUsers("1")?.enqueue(object : Callback<AllUsersInfo?> {
                override fun onResponse(
                    call: Call<AllUsersInfo?>,
                    response: Response<AllUsersInfo?>
                ) {

                    if (response?.isSuccessful!!) {

                        sampleListView = findViewById(R.id.recycleViewSample)
                        sampleListView.layoutManager = LinearLayoutManager(this@MainActivity8)
                        sampleListView.adapter =
                            response.body()?.let { sampleAdapter(this@MainActivity8, it.data)

                            }


                    } else {
                        Toast.makeText(this@MainActivity8, "Error", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<AllUsersInfo?>, t: Throwable) {
                    t.printStackTrace()
                    Toast.makeText(this@MainActivity8, "Something went wrong", Toast.LENGTH_LONG)
                        .show()
                }

            })
        } else {
            Toast.makeText(
                this@MainActivity8,
                "Please check you internet connection",
                Toast.LENGTH_LONG
            ).show()
        }
    }


}