package com.example.zabbixviewer

//import com.github.kittinunf.fuel.core.FuelManager.basePath
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager.Companion.instance
import com.github.kittinunf.fuel.core.extensions.jsonBody
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        instance.basePath = "http://demosmushtaq.16mb.com"
       // val request = ""
        //val response = ""
        //val
        lateinit var request: String
        lateinit var response: String
        lateinit var result: String

        lateinit var button: Button
        lateinit var editText: EditText
        lateinit var string: String
        lateinit var slink: TextView
        lateinit var uname: TextView
        lateinit var pword: TextView

        lateinit var authtoken: String

        button = findViewById(R.id.log_in)
        slink = findViewById(R.id.serverlink_txt)
        uname = findViewById(R.id.user_name)
        pword = findViewById(R.id.pass_word)

        val body = JSONObject();

        body.put("jsonrpc", "")
        body.put("method", "user.login")
        body.put("id","1")

        val params = JSONObject()

        //params.put("user", uname)
        //params.put("password", pword)

        params.put("user", uname)
        params.put("password", pword)

        body.put("params", params)

        //{
        //    "jsonrpc": "2.0",
        //    "result": "0424bd59b807674191e7d77572075f33",
        //    "id": 1
        //}

        Fuel.post(slink.toString())
        //Fuel.post(slink.text.toString())
                .jsonBody(body.toString())
                .responseString { request, response, result ->
                    result.fold(
                            success = {
                                      val json = JSONObject(it)
                                      authtoken = json.optString("result", "KEY_NOT_FOUND")
                                      Log.i("[myapp]", authtoken)
                            },
                            failure = {

                            }
                    )
                }


        // Fuel.get("https://httpbin.org/get")
        //        .response{ request, response, result ->
        //         println(request),
        //        println(response),
        //        val (bytes, error) = result,
        //        if (bytes != null) {
        //        println("[response bytes] ${String(bytes)}")
        //    }
        // }
    }

    //fun onBtnClick(view: View?) {
    //    val servername = findViewById<TextView>(R.id.serverlink_txt)
    //    servername.text = "I WANT Address"
    //}

    companion object {

    }

    fun onBtnClick(view: View) {}
}