package com.calvert.kotlinretrofitrxjavarecyclerview3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.calvert.kotlinretrofitrxjavarecyclerview3.adapter.MyAdapter
import com.calvert.kotlinretrofitrxjavarecyclerview3.model.Comment
import com.calvert.kotlinretrofitrxjavarecyclerview3.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //init later using lateinit
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofit().getPost()
        apiInterface.enqueue(object: Callback<List<Comment>> {
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.e("Error", t.message)
            }

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                //!! means not null type
                myAdapter = MyAdapter(this@MainActivity, response.body()!!)
                recyclerView.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }
        })
    }
}

