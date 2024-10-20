package com.gouravsh.stackmarketapp.data.remote

import com.gouravsh.stackmarketapp.data.remote.dto.CompanyInfoDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("query?function=TIME_SERIES_INTRADAY&=IBM&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("symbol") symbol: String
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY,
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "LM2X9ID68WOAVEX8"
        const val BASE_URL = "https://alphavantage.co"
    }
}