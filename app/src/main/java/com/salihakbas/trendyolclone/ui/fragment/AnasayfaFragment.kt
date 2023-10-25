package com.salihakbas.trendyolclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.salihakbas.trendyolclone.R
import com.salihakbas.trendyolclone.UrunAdapter
import com.salihakbas.trendyolclone.data.Urun
import com.salihakbas.trendyolclone.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        binding.rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val urunList = ArrayList<Urun>()
        val u1 = Urun("zumrut_yesil", getString(R.string.zümrüt_yesili),"419.99","95",4.5f,true,true,true)
        val u2 = Urun("kahverengi",getString(R.string.camel_unisex),"359.99","2145",4.8f,true,false,true)
        val u3 = Urun("kahverengi_erkek",getString(R.string.kahverengi_erkek),"379.99","394",4.0f,true,false,true)
        val u4 = Urun("bej",getString(R.string.ekru_unisex),"349.99","380",5.0f,true,false,true)
        val u5 = Urun("minnesota",getString(R.string.kahverengi_unisex),"359.99","46",3.6f,true,false,true)
        val u6 = Urun("revival",getString(R.string.siyah_unisex),"349.99","1694",4.5f,true,false,true)
        val u7 = Urun("vizon",getString(R.string.vizon_unisex),"229.99","11",3.6f,true,false,true)
        val u8 = Urun("gri",getString(R.string.limited_edition),"429.99","2",3.0f,true,true,true)


        urunList.add(u1)
        urunList.add(u2)
        urunList.add(u3)
        urunList.add(u8)
        urunList.add(u4)
        urunList.add(u5)
        urunList.add(u6)
        urunList.add(u7)


        val urunAdapter = UrunAdapter(requireContext(),urunList)
        binding.rv.adapter = urunAdapter

        return binding.root
    }


}