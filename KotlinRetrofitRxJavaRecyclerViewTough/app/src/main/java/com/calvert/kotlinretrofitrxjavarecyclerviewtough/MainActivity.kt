package com.calvert.kotlinretrofitrxjavarecyclerviewtough

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.calvert.kotlinretrofitrxjavarecyclerviewtough.adapter.MyAdapter
import com.calvert.kotlinretrofitrxjavarecyclerviewtough.model.User
import com.calvert.kotlinretrofitrxjavarecyclerviewtough.network.ApiInterface
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofit().getUsers()
//        apiInterface.enqueue(object: Callback<User>{
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                Log.d("Response", response.body().toString())
//                adapter = MyAdapter(this@MainActivity, response.body()?.data!!.toList())
//                recyclerView.adapter = adapter
//                adapter.notifyDataSetChanged()
//            }
//        })
            // do in background thread
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({it ->
                Log.d("response", it.toString())
                adapter = MyAdapter(this@MainActivity, it?.data!!.toList())
                recyclerView.adapter = adapter
            }, {it ->
                Log.e("failure", it.message)
            })
    }
}
