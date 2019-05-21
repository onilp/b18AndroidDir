package com.calvert.retrofitrxjavadagger2practice.network;

import com.calvert.retrofitrxjavadagger2practice.model.UsersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users/")
    Observable<List<UsersResponse>> getUsers();
}
