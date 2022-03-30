package com.rickyandrean.remoney.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rickyandrean.remoney.R
import com.rickyandrean.remoney.databinding.ItemTimeFrameBinding

class TimeFrameAdapter(private val timeFrameList: List<String>): RecyclerView.Adapter<TimeFrameAdapter.TimeFrameViewholder>() {
    class TimeFrameViewholder(var binding: ItemTimeFrameBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeFrameViewholder {
        val binding = ItemTimeFrameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimeFrameViewholder(binding)
    }

    override fun onBindViewHolder(holder: TimeFrameViewholder, position: Int) {
        with(holder.binding) {
            tvTimeFrameValue.text = timeFrameList[position]

            if (position == 2) {
                cvItemTimeFrame.setBackground(ContextCompat.getDrawable(holder.itemView.context, R.drawable.bg_time_frame_active))
                tvTimeFrameValue.setTextColor(Color.parseColor("#FFFFFF"))
            }

            if (position == 4) {
                cvItemTimeFrame.setBackground(ContextCompat.getDrawable(holder.itemView.context, R.drawable.bg_time_frame_now))
            }
        }


    }

    override fun getItemCount(): Int = timeFrameList.size
}