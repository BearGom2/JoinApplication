package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.joinapplication.Data.ClientJoin
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.id_Edt_SignUp
import kotlinx.android.synthetic.main.activity_sign_up.psw_Edt_SignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        signUp_Btn_SignUp.setOnClickListener {
            val id = id_Edt_SignUp.text.toString()
            val password = psw_Edt_SignUp.text.toString()

            val call_R: Call<Void> = ClientJoin.getJoinClient.SignUp(id,password)
            call_R.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "회원가입 실패!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response!!.code() == 200) {
                        val intent = Intent(baseContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            })
        }
    }
}
