package com.kata.berlinclock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kata.berlinclock.R
import com.kata.berlinclock.adapter.FiveMinutesAdapter.Companion.EIGHT
import com.kata.berlinclock.databinding.BerlinClockItemLayoutBinding
import com.kata.berlinclock.model.Hours
import com.kata.berlinclock.utils.LampColor
import com.kata.berlinclock.utils.LampColor.*

class HoursAdapter : RecyclerView.Adapter<HoursAdapter.MyViewHolder>() {

    private lateinit var hoursOnLamps: List<LampColor>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView =
            BerlinClockItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            holder.bind(hoursOnLamps[position], context)
        }
    }

    override fun getItemCount() = EIGHT

    fun setHoursValue(hoursValue: Hours) {
        hoursOnLamps = hoursValue.topColors + hoursValue.bottomColors
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val binding: BerlinClockItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hour: LampColor, context: Context) {
            binding.itemBtn.background =
                ContextCompat.getDrawable(context, R.drawable.minutes_button_background)
            binding.itemBtn.isEnabled = hour != OFF
        }
    }
}