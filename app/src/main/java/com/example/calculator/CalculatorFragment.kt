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

    private var currentInput = ""
    private var lastOperator = ""
    private var result = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 数字ボタンのリスナー設定
        binding.zeroButton.setOnClickListener { appendNumber("0") }
        binding.oneButton.setOnClickListener { appendNumber("1") }
        binding.twoButton.setOnClickListener { appendNumber("2") }
        binding.threeButton.setOnClickListener { appendNumber("3") }
        binding.fourButton.setOnClickListener { appendNumber("4") }
        binding.fiveButton.setOnClickListener { appendNumber("5") }
        binding.sixButton.setOnClickListener { appendNumber("6") }
        binding.sevenButton.setOnClickListener { appendNumber("7") }
        binding.eightButton.setOnClickListener { appendNumber("8") }
        binding.nineButton.setOnClickListener { appendNumber("9") }

        // 演算ボタンのリスナー設定
        binding.plusButton.setOnClickListener { performOperation("+") }
        binding.minusButton.setOnClickListener { performOperation("-") }
        binding.multiplyButton.setOnClickListener { performOperation("*") }
        binding.divideButton.setOnClickListener { performOperation("/") }

        binding.decimalPointButton.setOnClickListener { appendDecimal() }
        binding.percentageButton.setOnClickListener { calculatePercent() }

        // クリアボタン
        binding.resetButton.setOnClickListener {
            clear()
        }

        // イコールボタン
        binding.equalButton.setOnClickListener {
            calculateResult()
        }
    }

    private fun appendNumber(number: String) {
        if (currentInput.isEmpty() && number == "0") {
            // 最初に0が入力された場合は無視
            return
        }
        currentInput += number
        binding.number.text = currentInput
    }

    private fun performOperation(operator: String) {
        if (currentInput.isNotEmpty()) {
            calculateResult()
            lastOperator = operator
            currentInput = ""
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty()) {
            val currentNumber = currentInput.toDouble()

            // 0除算を防ぐ
            if (lastOperator == "/" && currentNumber == 0.0) {
                binding.number.text = "Error"
                return
            }

            result = when (lastOperator) {
                "+" -> result + currentNumber
                "-" -> result - currentNumber
                "*" -> result * currentNumber
                "/" -> result / currentNumber
                else -> currentNumber
            }
            binding.number.text = result.toString()
            currentInput = result.toString()
        }
    }

    private fun appendDecimal() {
        if (!currentInput.contains(".")) {
            currentInput += "."
            binding.number.text = currentInput
        }
    }

    private fun calculatePercent() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDouble() / 100
            binding.number.text = value.toString()
            currentInput = value.toString()
        }
    }

    private fun clear() {
        currentInput = ""
        lastOperator = ""
        result = 0.0
        binding.number.text = "0"
    }
}