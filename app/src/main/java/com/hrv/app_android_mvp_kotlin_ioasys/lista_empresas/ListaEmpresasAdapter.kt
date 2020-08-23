package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import Empresa
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.hrv.app_android_mvp_kotlin_ioasys.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.GlideUtil


class ListaEmpresasAdapter(var context: Context, private var lista: List<Empresa>) : BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "UseCompatLoadingForDrawables")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        val empresa: Empresa = getItem(position) as Empresa

        val inflate =
            LayoutInflater.from(context).inflate(R.layout.item_empresas_lista, parent, false)

        val txtNomeEmpresa = inflate.findViewById<TextView>(R.id.txtNomeEmpresa)
        val txtTipoEmpresa = inflate.findViewById<TextView>(R.id.txtTipoEmpresa)
        val txtPaisEmpresa = inflate.findViewById<TextView>(R.id.txtPaisEmpresa)
        val ivLogoEmpresa = inflate.findViewById<ImageView>(R.id.ivLogoEmpresa)
        val pbImagemEmpresa = inflate.findViewById<ProgressBar>(R.id.pbImagemEmpresa)

        val url = "${Constantes.URL_BASE}${empresa.photo}"

        GlideUtil.carregarImagemPelaUrl(context, pbImagemEmpresa, ivLogoEmpresa, url)
        txtNomeEmpresa.text = empresa.enterprise_name
        txtTipoEmpresa.text = empresa.enterprise_type.enterprise_type_name
        txtPaisEmpresa.text = empresa.country

        return inflate
    }
}