package com.rickyandrean.remoney.ui.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickyandrean.remoney.R
import com.rickyandrean.remoney.adapter.ExpensesAdapter
import com.rickyandrean.remoney.adapter.TimeFrameAdapter
import com.rickyandrean.remoney.api.Expenses
import com.rickyandrean.remoney.databinding.FragmentExpensesBinding
import com.rickyandrean.remoney.ui.datetime.DatePickerFragment
import com.rickyandrean.remoney.ui.datetime.TimePickerFragment
import com.rickyandrean.remoney.ui.newexpenses.NewExpensesFragment

class ExpensesFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!

    private lateinit var expenses: ArrayList<Expenses>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expenses = ArrayList(
            listOf(
                Expenses("12:30", "Eat food at Barokah", "15.000"),
                Expenses("18:40", "Eat food at Mas Bro", "18.000"),
                Expenses("20:10", "Parkir Masbro", "2.000"),
                Expenses("20:20", "Buy Pillows and Sponge at Alfamidi", "25.000")
            )
        )

        val time: MutableList<String> = mutableListOf("26 MAR", "27 MAR", "28 MAR", "29 MAR", "30 MAR")
        val timeFrameList: List<String> = time

        binding.rvTimeFrame.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = TimeFrameAdapter(timeFrameList)
        }

        binding.rvExpenses.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = ExpensesAdapter(expenses)
        }

        binding.fabAddExpenses.setOnClickListener(this)
        binding.cvDate.setOnClickListener(this)
        binding.cvTimeframe.setOnClickListener(this)
        binding.cvCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabAddExpenses -> {
                NewExpensesFragment().show(childFragmentManager, NewExpensesFragment::class.java.simpleName)
            }
            R.id.cvDate -> Toast.makeText(requireActivity(), "Ini Date Picker", Toast.LENGTH_SHORT).show()
            R.id.cvTimeframe -> Toast.makeText(requireActivity(), "Ini Timeframe Selectbox", Toast.LENGTH_SHORT).show()
            R.id.cvCategory -> Toast.makeText(requireActivity(), "Ini Category Selectbox", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}