package com.patrick.fittracker.record.selftraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patrick.fittracker.data.AddTrainingRecord
import com.patrick.fittracker.databinding.ItemRecordAddSetBinding


//class RecordAdapter(val onClickListener: OnClickListener):
class RecordAdapter():
    ListAdapter<AddTrainingRecord, RecordAdapter.RecordViewHolder>(DiffCallback){

    class RecordViewHolder(private var binding: ItemRecordAddSetBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(add: AddTrainingRecord){
            binding.add = add
            binding.executePendingBindings()

        }
    }


    companion object DiffCallback: DiffUtil.ItemCallback<AddTrainingRecord>(){
        override fun areContentsTheSame(oldItem: AddTrainingRecord, newItem: AddTrainingRecord): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: AddTrainingRecord, newItem: AddTrainingRecord): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(
            ItemRecordAddSetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int){
        val menu = getItem(position)
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(menu)
//        }
        holder.bind(menu)
    }

    class OnClickListener(val clickListener: (add: AddTrainingRecord) -> Unit) {
        fun onClick(add: AddTrainingRecord) = clickListener(add)
    }
}