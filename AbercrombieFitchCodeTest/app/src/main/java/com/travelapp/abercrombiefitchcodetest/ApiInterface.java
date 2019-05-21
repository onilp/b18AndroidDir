package com.travelapp.abercrombiefitchcodetest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("codeTest_exploreData.json/")
    Observable<List<ShoppingModel>> getShopping();
}
