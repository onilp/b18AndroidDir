package com.calvert.retrofitrxjavadagger2.network;

import com.calvert.retrofitrxjavadagger2.model.AlbumResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("albums/")
    Observable<List<AlbumResponse>> getAlbums();
}
