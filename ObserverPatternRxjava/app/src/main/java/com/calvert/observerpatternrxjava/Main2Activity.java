package com.calvert.observerpatternrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    static final String TAG = Main2Activity.class.getSimpleName();
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Observable<String> nameObservable = setNames();
        Observable<Integer> numObservable = setNums();

        Observer<String> nameObserver = getNames();
        Observer<String> numObserver = getNums();

        //RxAndroid have schedulers
        nameObservable.subscribeOn(Schedulers.io()) // tell observable to send data in background thread
                .observeOn(AndroidSchedulers.mainThread()) //tells observer to receive on UI
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.toLowerCase().endsWith("l");
                    }
                })
                .map(new Function<String, String>(){
                    @Override
                    public String apply(String s) throws Exception {
                        return s.toUpperCase();
                    }
                })
                .subscribeWith(nameObserver);

        //RxAndroid have schedulers
        numObservable.subscribeOn(Schedulers.io()) // tell observable to send data in background thread
                .observeOn(AndroidSchedulers.mainThread()) //tells observer to receive on UI
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) throws Exception {
                        return i % 2 == 0;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer.toString() + " To string";
                    }
                })
                .subscribeWith(numObserver);
    }

    protected void onDestory() {
        super.onDestroy();
        //end subscription
        disposable.dispose();
    }

    private Observable<String> setNames() {
        return Observable.just("onil", "cal", "bin");
    }

    private Observable<Integer> setNums() {
        return Observable.just(1, 2, 3, 4, 5);
    }

    private Observer<String> getNames() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
    }

    private Observer<String> getNums() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(String i) {
                Log.d(TAG, "onNext: " + i);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
    }
}
