package com.hrv.app_android_mvp_kotlin_ioasys.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas.ListaEmpresaActivity
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.Util
import kotlinx.android.synthetic.main.login_activity.*

@Suppress("UNREACHABLE_CODE")
class LoginActivity : AppCompatActivity(), ILogin.View {

    private lateinit var presenter: ILogin.Presenter
    private val INPUT_TYPE_PASSWORD_TEXT: Int = 129

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        configurarElementosIniciais()

        presenter = LoginPresenter(this)

        ivVisibilidadeSenha.setOnClickListener {
            mudarVisibilidadeDaSenha()
        }

        btnLogin.setOnClickListener {
            lblMsgErro.visibility = View.INVISIBLE
            presenter.validarDadosLogin(etUsuario.text.toString(), etSenha.text.toString())
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun mudarVisibilidadeDaSenha() {
        if (etSenha.inputType == INPUT_TYPE_PASSWORD_TEXT) {
            etSenha.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            ivVisibilidadeSenha.setImageDrawable(getDrawable(R.drawable.ic_login_visibility_off_24))
        } else {
            etSenha.inputType = INPUT_TYPE_PASSWORD_TEXT
            ivVisibilidadeSenha.setImageDrawable(getDrawable(R.drawable.ic_login_visibility_24))
        }
    }

    fun configurarElementosIniciais() {
        supportActionBar!!.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.warm_grey)
        etSenha.inputType = INPUT_TYPE_PASSWORD_TEXT
    }

    override fun iniciarLogin() {
        btnLogin.visibility = View.GONE
        progressLogin.visibility = View.VISIBLE
        etUsuario.isEnabled = false
        etSenha.isEnabled = false
        ivVisibilidadeSenha.isEnabled = false
    }

    override fun terminarLogin() {
        etUsuario.isEnabled = true
        etSenha.isEnabled = true
        ivVisibilidadeSenha.isEnabled = true
        btnLogin.visibility = View.VISIBLE
        progressLogin.visibility = View.GONE
    }

    override fun camposVazios() {
        Toast.makeText(this, "Campos Vazios", Toast.LENGTH_SHORT).show()
    }

    override fun dadosIncorretos() {
        lblMsgErro.visibility = View.VISIBLE
        terminarLogin()
    }

    override fun sucessoAoLogar() {
        val intent =
            Intent(this, ListaEmpresaActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }

}