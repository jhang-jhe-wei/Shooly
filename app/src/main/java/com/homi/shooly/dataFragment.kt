package com.homi.shooly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_data.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [dataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class dataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val photos= arrayOf(R.drawable.shooly07,R.drawable.shooly08,R.drawable.shooly09,R.drawable.shooly10)
    val names= arrayOf("小虎","福仔","建宏","阿德")
    val locations= arrayOf("朴子市、太保市","嘉義市、民雄鄉、水上鄉、大林鎮","嘉義市、民雄鄉、太保市","水上鄉、中埔鄉")
    val stars= arrayOf("★   ★   ★   ★   ★","★   ★   ★","★   ★   ★   ★","★   ★   ★   ★   ★")
    val times= arrayOf("100次","27次","30次","77次")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val i=arguments?.getInt("index")
        imageview_information.setImageResource(photos[i!!])
        textview_information_name.text=names[i]
        textview_information_star.text=stars[i]
        textview_information_comments.text="11則評論"
        textview_service_type.text="修理家電、通馬桶、抓漏"
        textview_service_area.text=locations[i]
        textview_information_experience.text="5 年"
        textview_information_license.text="屋內線路裝修(甲級),工業配線(丙級),自來水配管(丙級),氣壓(丙級),用電設備(丙級)"
        textview_information_other.text="達人盃冠軍"

        textview_information_comments.setOnClickListener { findNavController().navigate(R.id.evaluateFragment) }
        btn_contact.setOnClickListener { findNavController().navigate(R.id.chatFragment) }

    }
}
