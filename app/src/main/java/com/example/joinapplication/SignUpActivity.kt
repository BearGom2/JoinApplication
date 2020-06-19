package com.example.joinapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.joinapplication.Data.ClientJoin
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class SignUpActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private lateinit var mVerificationId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        initFireBaseCallbacks()
        phoneNumAuth_Btn_SignUp.setOnClickListener {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNum_Edt_SignUp.text.toString(), 1, TimeUnit.MINUTES, this, mCallbacks!!
            )

        }

        numAuth_Btn_SignUp.setOnClickListener { CodeAuth() }

        signUp_Btn_SignUp.setOnClickListener {
            SignUp()
        }
    }

    fun SignUp(){
        val id = id_Edt_SignUp.text.toString()
        val password = psw_Edt_SignUp.text.toString()

        val call_R: Call<Void> = ClientJoin.getJoinClient.SignUp(id, password)
        call_R.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "회원가입 실패!", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200) {
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }

    private fun initFireBaseCallbacks() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            }

            override fun onVerificationFailed(e: FirebaseException) {
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                mVerificationId = verificationId
                Toast.makeText(applicationContext, "코드 전송!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun CodeAuth(){
            val credential =
                PhoneAuthProvider.getCredential(mVerificationId, reEnterPN_Edt_SignUp.text.toString())
            mAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "인증 성공!", Toast.LENGTH_SHORT).show()
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(applicationContext, "인증번호가 틀렸습니다.", Toast.LENGTH_SHORT).show() }
                }
            }
    }
}
