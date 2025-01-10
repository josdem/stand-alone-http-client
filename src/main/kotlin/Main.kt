package com.josdem.http.client

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException


var client: OkHttpClient = OkHttpClient()

fun main() {
    post("http://localhost:8081/emailer/message", "{\"name\":\"josdem\",\"email\":\"joseluis.delacruz@gmail.com\",\"message\":\"Hello from curl!\", \"template\":\"message.ftl\",\"token\":\"userToken\"}")
}

@Throws(IOException::class)
fun post(url: String, json: String): String {
    val body: RequestBody = RequestBody.create("application/json".toMediaType(), json)
    val request: Request = url.let {
        Request.Builder()
        .url(url)
        .post(body)
        .build()
    }

    client.newCall(request).execute().use { response ->
        return response.body!!.string()
    }
}