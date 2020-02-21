package com.example.dagger.di

//import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import android.util.Log
import com.example.dagger.network.NewsFeedApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class AppModule {

    class Intercept :
        Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val url = request.url().newBuilder()
                .addQueryParameter("apiKey", "28d8056669bc4b388ac63c40939a4489")
                .addQueryParameter("country", "us")
                .build()

            val newRequest = request.newBuilder()
                .url(url)
                .build()

            Log.e("----", newRequest.toString())

            return chain.proceed(newRequest)
        }
    }

    @Provides
    fun getInterceptor(): Intercept {
        return Intercept()
    }

    @Provides
    fun getHttpClient(intercept: Intercept): OkHttpClient {
        var client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(intercept)
            .build()
        return client;

    }


    @Provides
    fun providesRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun providesNewFeedApi(retrofit: Retrofit): NewsFeedApi {
        return retrofit.create(NewsFeedApi::class.java)
    }

}