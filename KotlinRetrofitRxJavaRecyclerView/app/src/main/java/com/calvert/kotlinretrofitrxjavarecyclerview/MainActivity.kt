package com.calvert.kotlinretrofitrxjavarecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.calvert.kotlinretrofitrxjavarecyclerview.adapter.MyAdapter
import com.calvert.kotlinretrofitrxjavarecyclerview.model.Post
import com.calvert.kotlinretrofitrxjavarecyclerview.network.ApiInterface
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

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofit().getPost()
        apiInterface.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("Error", t.message)
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                //!! means not null type
                myAdapter = MyAdapter(this@MainActivity, response.body()!!)
                recyclerView.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }
        })
    }
}
