package com.zenika.codingclub;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static java.util.stream.Collectors.toList;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        final String[] urls = {
                "http://google.com",
                "http://bing.com",
                "http://zenika.com",
                "http://romainvernoux.fr",
                "http://example.com",
                "http://doesnotexist.fr",
                "https://foo.mobiliz.zenikalabs.com"
        };

        BehaviorSubject<String> subject = BehaviorSubject.create();
        Observable.interval(0, 5, TimeUnit.SECONDS)
                .flatMap(time -> Observable.fromArray(urls))
                .map(HelloWorld::ping)
                .subscribe(subject::onNext);

        subject.filter(u -> u.startsWith("OK"))
                .subscribe(System.out::println);
        subject.filter(u -> u.startsWith("KO"))
                .buffer(4)
                .map(l -> "found errors: " + l)
                .subscribe(System.err::println);


        // wait for observable to complete (never in this case...)
        latch.await();
    }

    private static String ping(String url) throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            final int status = client.send(request, ofString()).statusCode();
            if (status >= 100 && status < 400) {
                return "OK - " + url;
            }
            return "KO - " + url;
        } catch (IOException e) {
            return "KO - " + url;
        }
    }
}
