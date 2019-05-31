package com.calvert.kotlinretrofitrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ThemedSpinnerAdapter
import android.util.Log
import com.calvert.kotlinretrofitrecyclerview.adapter.MyAdapter
import com.calvert.kotlinretrofitrecyclerview.model.UserModel
import com.calvert.kotlinretrofitrecyclerview.model.Users
import com.calvert.kotlinretrofitrecyclerview.network.ApiInterface
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

//    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofit().getUsers()
//        apiInterface.enqueue(object: Callback<UserModel> {
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                Log.e("Error", t.message)
//            }
//
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                //!! means not null type
//                myAdapter = MyAdapter(this@MainActivity, response.body()?.data!!.toList())
//                recyclerview.adapter = myAdapter
//                myAdapter.notifyDataSetChanged()
//            }
//        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({it->
                myAdapter = MyAdapter(this@MainActivity, it?.data!!.toList())
                recyclerview.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }, {it ->
                Log.e("Error", it.message)
            })
    }
}
