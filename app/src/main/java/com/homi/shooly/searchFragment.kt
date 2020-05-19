package com.homi.shooly

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [searchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private val TAG = searchFragment::class.java.simpleName

class searchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_search.setOnClickListener { findNavController().navigate(R.id.searchResultFragment) }
        val searchAdapter = SearchAdapter()
        val str = mutableListOf<String>()
        str.add("馬桶疏通")
        str.add("清洗水塔")
        str.add("自來水管堵塞")
        str.add("抓漏")
        str.add("清潔打掃")
        str.add("粉刷油漆")
        str.add("玻璃更換")
        str.add("冷氣查修")
        str.add("修理紗窗門")

        searchAdapter.setList(str)
        val gridlayoutManager = GridLayoutManager(context, 40 ,GridLayoutManager.VERTICAL,false)
        gridlayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return str[position].length*2+1
            }
        }

        recycleview_search.layoutManager = gridlayoutManager
        recycleview_search.adapter = searchAdapter
    }

    inner class SearchAdapter : RecyclerView.Adapter<SearchAdapter.PagerViewHolder>() {
        var data = mutableListOf<String>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
            var itemView: View
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_button_layout, parent, false)
            return PagerViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
            holder.bind(position)
        }


        fun setList(list: MutableList<String>) {
            data = list
        }

        override fun getItemCount(): Int {
            return data.size
        }



        //	ViewHolder需要繼承RecycleView.ViewHolder
        inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(i: Int) {
                val item: TextView = itemView.findViewById(R.id.search_holder_item)
                item.setText(data[i])
                item.setOnClickListener { textview_search.setText(item.text.toString()) }
            }


        }
    }
}
