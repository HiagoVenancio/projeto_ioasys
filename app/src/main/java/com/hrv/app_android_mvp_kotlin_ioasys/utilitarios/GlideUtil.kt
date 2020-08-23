package com.hrv.app_android_mvp_kotlin_ioasys.utilitarios

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hrv.app_android_mvp_kotlin_ioasys.R

abstract class GlideUtil {

    companion object {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun carregarImagemPelaUrl(
            context: Context,
            progressBar: ProgressBar,
            imagemview: ImageView,
            url: String
        ) {

            /*trataiva para quando vier com valor NULL de foto */
            if (url.length < 40) {
                carregarImagemLocal(context, imagemview)
            } else {
                progressBar.visibility = View.VISIBLE
                Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .error(context.getDrawable(R.drawable.ic_android_120))
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressBar.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            progressBar.visibility = View.GONE
                            return false
                        }
                    })
                    .into(imagemview)
            }
        }


        @SuppressLint("UseCompatLoadingForDrawables")
        fun carregarImagemLocal(
            context: Context,
            imagemview: ImageView

        ) {
            Glide.with(context)
                .load(context.getDrawable(R.drawable.ic_android_120))
                .into(imagemview)
        }
    }
}