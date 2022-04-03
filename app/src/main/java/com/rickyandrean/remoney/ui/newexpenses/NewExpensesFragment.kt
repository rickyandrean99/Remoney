package com.rickyandrean.remoney.ui.newexpenses

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.rickyandrean.remoney.R
import com.rickyandrean.remoney.databinding.FragmentNewExpensesBinding
import com.rickyandrean.remoney.ui.datetime.DatePickerFragment
import com.rickyandrean.remoney.ui.datetime.TimePickerFragment
import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import java.text.SimpleDateFormat
import java.util.*


class NewExpensesFragment : DialogFragment(), View.OnClickListener {
    private var _binding: FragmentNewExpensesBinding? = null
    private val binding get() = _binding!!
    private lateinit var dateSelected: String
    private lateinit var timeSelected: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dialog fragment behaviour
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout((displayMetrics.widthPixels * 0.8).toInt(), 1400)

        // Update date time now
        dateSelected = SimpleDateFormat("dd MMMM yyyy").format(Date()).toString()
        timeSelected = SimpleDateFormat("HH:mm").format(Date()).toString()
        updateTime()

        // Button Listener
        binding.cvDateTime.setOnClickListener(this)
        binding.btnCancel.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cvDateTime -> {
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(DATE_PICKER_TAG, viewLifecycleOwner) { resultKey, bundle ->
                    if (resultKey == DATE_PICKER_TAG) {
                        dateSelected = bundle.getString(SELECTED_DATE)!!
                        TimePickerFragment().show(supportFragmentManager, TIME_PICKER_TAG)
                    }
                }

                supportFragmentManager.setFragmentResultListener(TIME_PICKER_TAG, viewLifecycleOwner) { resultKey, bundle ->
                    if (resultKey == TIME_PICKER_TAG) {
                        timeSelected = bundle.getString(SELECTED_TIME)!!
                        updateTime()
                    }
                }

                DatePickerFragment().show(supportFragmentManager, DATE_PICKER_TAG)
            }
            R.id.btnCancel -> {
                dialog?.cancel()
            }
            R.id.btnSubmit -> {

            }
        }
    }

    private fun updateTime() {
        binding.tvDateTimeValue.text = "$dateSelected $timeSelected"
    }

    companion object {
        const val DATE_PICKER_TAG = "DatePicker"
        const val TIME_PICKER_TAG = "TimePicker"
        const val SELECTED_DATE = "SelectedDate"
        const val SELECTED_TIME = "SelectedTime"

    }
}