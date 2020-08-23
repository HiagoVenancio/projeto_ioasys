package com.hrv.app_android_mvp_kotlin_ioasys.detalhe_empresa

import Empresa
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.GlideUtil
import kotlinx.android.synthetic.main.activity_detalhe_lista_empresas.*

class DetalheListaEmpresas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_lista_empresas)

        if (intent.hasExtra(Constantes.KEY_DETALHE_EMPRESA)) {
            val empresa: Empresa =
                intent.getSerializableExtra(Constantes.KEY_DETALHE_EMPRESA) as Empresa

            supportActionBar!!.title = empresa.enterprise_name
            txtDetalheEmpresa.text = empresa.description

            val url = "${Constantes.URL_BASE}${empresa.photo}"
            GlideUtil.carregarImagemPelaUrl(this, pbLogoEmpresaDetalhe, ivLogoEmpresaDetalhe, url)
        }
    }
}