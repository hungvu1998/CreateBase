package com.example.createbase.data.remote

import com.example.createbase.di.ApiInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHeader
constructor(val publicApiHeader: PublicApiHeader, val protectedApiHeader: ProtectedApiHeader) {

    class ProtectedApiHeader(
        @field:Expose
        @field:SerializedName("api_key")
        var apiKey: String?, @field:Expose
        @field:SerializedName("user_id")
        var userId: Long?, @field:Expose
        @field:SerializedName("access_token")
        var accessToken: String?
    )

    class PublicApiHeader
    constructor(
        @param:ApiInfo @field:Expose
        @field:SerializedName("api_key")
        var apiKey: String?
    )
}
