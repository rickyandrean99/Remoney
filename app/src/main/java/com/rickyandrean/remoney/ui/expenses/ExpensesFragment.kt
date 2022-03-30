package com.rickyandrean.remoney.ui.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickyandrean.remoney.R
import com.rickyandrean.remoney.adapter.TimeFrameAdapter
import com.rickyandrean.remoney.databinding.FragmentExpensesBinding

class ExpensesFragment : Fragment() {
    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val time: MutableList<String> = mutableListOf("26 MAR", "27 MAR", "28 MAR", "29 MAR", "30 MAR")
        val timeFrameList: List<String> = time

        binding.rvTimeFrame.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = TimeFrameAdapter(timeFrameList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}