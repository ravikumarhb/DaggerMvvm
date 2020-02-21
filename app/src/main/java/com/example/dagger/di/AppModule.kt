package com.example.dagger.di

//import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.dagger.network.NewsFeedApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


// Application wide used classes like retrofit and sub dependencies
@Module
class AppModule {

    // added to that country and api key is passed in every request
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

            return chain.proceed(newRequest)
        }
    }

    @Provides
    fun getInterceptor(): Intercept {
        return Intercept()
    }

    // Client uses Interceptor provided above
    @Provides
    fun getHttpClient(intercept: Intercept): OkHttpClient {
        var client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(intercept)
            .build()
        return client;

    }


    // creates Retrofit and on injected HTTP client
    @Provides
    fun providesRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    // create newsfeedapi for GET calls
    @Provides
    fun providesNewFeedApi(retrofit: Retrofit): NewsFeedApi {
        return retrofit.create(NewsFeedApi::class.java)
    }

}