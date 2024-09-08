package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.zeroButton.setOnClickListener {

        }

        binding.decimalPointButton.setOnClickListener {

        }

        binding.equalButton.setOnClickListener {

        }

        binding.oneButton.setOnClickListener {

        }

        binding.twoButton.setOnClickListener {

        }

        binding.threeButton.setOnClickListener {

        }

        binding.plusButton.setOnClickListener {

        }

        binding.fourButton.setOnClickListener {

        }

        binding.fiveButton.setOnClickListener {

        }

        binding.sixButton.setOnClickListener {

        }

        binding.minusButton.setOnClickListener {

        }

        binding.sevenButton.setOnClickListener {

        }

        binding.eightButton.setOnClickListener {

        }

        binding.nineButton.setOnClickListener {

        }

        binding.multiplyButton.setOnClickListener {

        }

        binding.resetButton.setOnClickListener {

        }

        binding.plusMinusButton.setOnClickListener {

        }

        binding.percentageButton.setOnClickListener {

        }

        binding.divideButton.setOnClickListener {

        }

        binding.number.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}