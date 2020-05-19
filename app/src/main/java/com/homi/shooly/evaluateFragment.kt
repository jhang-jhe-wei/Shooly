package com.homi.shooly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_evaluate.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [evaluateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class evaluateFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evaluate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val evaluationAdapter=EvaluationAdapter()
        recycleview_evaluation.layoutManager= LinearLayoutManager(context)
        recycleview_evaluation.adapter=evaluationAdapter
    }
    inner class EvaluationAdapter : RecyclerView.Adapter<EvaluationAdapter.PagerViewHolder>() {
        var data = mutableListOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
            var itemView: View
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.evaluate_holder_layout, parent, false)
            return PagerViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
            holder.bind(position)
        }


        fun setList(list: MutableList<String>) {
            data = list
        }

        override fun getItemCount(): Int {
            return 5
        }



        //	ViewHolder需要繼承RecycleView.ViewHolder
        inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(i: Int) {
            }


        }
    }
}
