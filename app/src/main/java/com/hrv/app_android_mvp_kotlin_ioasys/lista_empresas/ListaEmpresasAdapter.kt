package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import Empresa
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.hrv.app_android_mvp_kotlin_ioasys.R

class ListaEmpresasAdapter(var context: Context, private var lista : List<Empresa>) : BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.item_empresas_lista, parent, false)

        val empresa : Empresa = getItem(position) as Empresa
        val txtNomeEmpresa = inflate.findViewById<TextView>(R.id.txtNomeEmpresa)
        val txtTipoEmpresa = inflate.findViewById<TextView>(R.id.txtTipoEmpresa)
        val txtPaisEmpresa = inflate.findViewById<TextView>(R.id.txtPaisEmpresa)

        txtNomeEmpresa.text = empresa.enterprise_name
        txtTipoEmpresa.text = empresa.enterprise_type.enterprise_type_name
        txtPaisEmpresa.text = empresa.country

        return inflate
    }
}