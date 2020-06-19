package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.joinapplication.Data.ClientJoin
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_Btn_Login.setOnClickListener {
            val id = id_Edt_Login.text.toString()
            val password = psw_Edt_Login.text.toString()

            val call_R: Call<Void> = ClientJoin.getJoinClient.getLogin(id,password)
            call_R.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "로그인 실패!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) {
                        Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT).show()
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            })
        }

        signUp_Tv_Login.setOnClickListener {
            val intent = Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
