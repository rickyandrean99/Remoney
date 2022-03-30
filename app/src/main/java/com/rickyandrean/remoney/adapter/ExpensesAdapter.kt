package com.rickyandrean.remoney.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rickyandrean.remoney.api.Expenses
import com.rickyandrean.remoney.databinding.ItemExpensesBinding

class ExpensesAdapter(private val expenses: ArrayList<Expenses>): RecyclerView.Adapter<ExpensesAdapter.ExpensesViewholder>() {
    class ExpensesViewholder(var binding: ItemExpensesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewholder {
        val binding = ItemExpensesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpensesViewholder(binding)
    }

    override fun onBindViewHolder(holder: ExpensesViewholder, position: Int) {
        with(holder.binding) {
            tvTime.text = expenses[position].time
            tvExpenses.text = expenses[position].name
            tvPrice.text = expenses[position].price
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, expenses[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = expenses.size
}