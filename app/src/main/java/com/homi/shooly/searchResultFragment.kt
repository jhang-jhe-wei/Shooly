package com.homi.shooly

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [searchResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class searchResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val photos= arrayOf(R.drawable.shooly07,R.drawable.shooly08,R.drawable.shooly09,R.drawable.shooly10)
    val names= arrayOf("小虎","福仔","建宏","阿德")
//    val locations= arrayOf("朴子市、太保市","嘉義市、民雄鄉、水上鄉、大林鎮","嘉義市、民雄鄉、太保市","水上鄉、中埔鄉")
    val locations= arrayOf("朴子市","嘉義市","嘉義市","水上鄉")
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
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchResultAdapter=SearchResultAdapter()
        val linearLayoutManager=LinearLayoutManager(context)
        recycleview_nearly_technicians.addItemDecoration(object :RecyclerView.ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                with(outRect){
                    bottom=60
                }
            }
        })
        recycleview_nearly_technicians.layoutManager=linearLayoutManager
        recycleview_nearly_technicians.adapter=searchResultAdapter
    }

    inner class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.PagerViewHolder>() {
        var data = mutableListOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
            var itemView: View
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_result_holder_layout, parent, false)
            return PagerViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
            holder.bind(position)
        }


        fun setList(list: MutableList<String>) {
            data = list
        }

        override fun getItemCount(): Int {
            return 4
        }



        //	ViewHolder需要繼承RecycleView.ViewHolder
        inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bind(i: Int) {
                val recycleview:RecyclerView=itemView.findViewById(R.id.search_result_holder_recycleview)
                val photo:ImageView=itemView.findViewById(R.id.search_result_holder_photo)
                val location:TextView=itemView.findViewById(R.id.search_result_holder_location)
                val name:TextView=itemView.findViewById(R.id.search_result_holder_name)
                val star:TextView=itemView.findViewById(R.id.search_result_holder_star)
                val service_time:TextView=itemView.findViewById(R.id.search_result_holder_service_time)
                val searchAdapter = SearchAdapter()
                val str = mutableListOf<String>()
                str.add("電器裝配")
                str.add("冷凍空調")

                searchAdapter.setList(str)
                recycleview.layoutManager = GridLayoutManager(context,3)
                recycleview.adapter = searchAdapter
                photo.setImageResource(photos[i])
                name.text=names[i]
                location.text=locations[i]
                star.text=stars[i]
                service_time.text=times[i].toString()
                val bundle=Bundle()
                bundle.putInt("index",i)
                itemView.setOnClickListener { findNavController().navigate(R.id.dataFragment,bundle) }
            }


        }
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
            }


        }
    }
}
