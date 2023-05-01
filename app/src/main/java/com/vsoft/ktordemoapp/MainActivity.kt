package com.vsoft.ktordemoapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking { getData() }
    }

     suspend fun getData() {
        val client = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
        var users : Array<User> = client.get("https://hub.dummyapis.com/employee?noofRecords=10&idStarts=1001").body()
        var res = ""
        users?.map { user -> res += user?.id + ", " + user?.firstName + " " + user?.lastName + ", " + user?.age + ", " + user?.salary + "\n" }
         val info = findViewById<TextView>(R.id.user_info);
         info.text = res
         println(res)
    }
}