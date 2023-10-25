package com.salihakbas.trendyolclone

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.italic
import androidx.recyclerview.widget.RecyclerView
import com.salihakbas.trendyolclone.data.Urun
import com.salihakbas.trendyolclone.databinding.CardViewBinding
import java.lang.reflect.Type

class UrunAdapter(var mContext: Context, val urunList: List<Urun>) :
    RecyclerView.Adapter<UrunAdapter.UrunViewHolder>() {

    inner class UrunViewHolder(var tasarim: CardViewBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return UrunViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return urunList.size
    }

    override fun onBindViewHolder(holder: UrunViewHolder, position: Int) {
        val urun = urunList.get(position)
        val t = holder.tasarim


        val spannable = SpannableString(urun.urunAd)
        spannable.setSpan(
            RelativeSizeSpan(1f),
            0,12,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0,
            12,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        t.tvUrunAd.text = spannable

        t.tvFYat.text = "${urun.urunFiyat} TL"
        t.tvYorumSayS.text = "(${urun.urunYorum})"
        t.imgUrun.setImageResource(mContext.resources.getIdentifier(urun.resim,"drawable",mContext.packageName))
        if(urun.video) {
            t.imgVideo.setImageResource(R.drawable.videolu_urun)
        }else{
            t.imgVideo.visibility = View.GONE
        }
        if(urun.fenomen) {
            t.imgFenomen.setImageResource(R.drawable.fenomen_secimi)
        }else{
            t.imgFenomen.visibility = View.GONE
        }
        if(urun.kamera) {
            t.imgKamera.setImageResource(R.drawable.kamera)
        }else{
            t.imgKamera.visibility = View.GONE
        }
        t.myRatingBar.rating = urun.rating

    }
}