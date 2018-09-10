package com.didispace.test;

import rx.Observable;
import rx.Subscriber;

public class Obs_Subs {

    public static void main(String[] args) {

        //创建事件源
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava ");
                subscriber.onNext("I'm XX");
                subscriber.onCompleted();
            }
        });

        //创建订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("throwable");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext");
            }
        };

        observable.subscribe(subscriber);
        observable.publish();
    }
}