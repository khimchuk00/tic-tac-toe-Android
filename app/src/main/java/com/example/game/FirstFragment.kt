package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.game.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var isXMark: Boolean = true
    private var winCombinations = arrayOf(arrayOf(1, 2, 3), arrayOf(1, 4, 7), arrayOf(1, 5, 9), arrayOf(2, 5, 8),
                                          arrayOf(4, 5, 6), arrayOf(3, 6, 9), arrayOf(7, 8, 9), arrayOf(3, 5, 7))

    private var xArray: Array<Int> = arrayOf()
    private var oArray: Array<Int> = arrayOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun checkExpresion(button: Button, value: Int) {
        if (button.text.isEmpty()) {
            if (isXMark) {
                button.text = "X"
                xArray += value
                isXMark = false

                checkWin(true)
            } else {
                button.text = "○"
                oArray += value
                isXMark = true

                checkWin(false)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            checkExpresion(binding.buttonFirst, 1)
        }

        binding.buttonSecond.setOnClickListener {
            checkExpresion(binding.buttonSecond, 2)
        }

        binding.buttonThird.setOnClickListener {
            checkExpresion(binding.buttonThird, 3)
        }

        binding.buttonFourth.setOnClickListener {
            checkExpresion(binding.buttonFourth, 4)
        }

        binding.buttonFifth.setOnClickListener {
            checkExpresion(binding.buttonFifth, 5)
        }

        binding.buttonSixth.setOnClickListener {
            checkExpresion(binding.buttonSixth, 6)
        }

        binding.buttonSeventh.setOnClickListener {
            checkExpresion(binding.buttonSeventh, 7)
        }

        binding.buttonEighth.setOnClickListener {
            checkExpresion(binding.buttonEighth, 8)
        }

        binding.buttonNineth.setOnClickListener {
            checkExpresion(binding.buttonNineth, 9)
        }

        binding.resetButton.setOnClickListener {
            isXMark = true
            setButtonsEnabled(isEnabled = true)
            binding.textviewSecond.text = ""
            binding.buttonFirst.text = ""
            binding.buttonSecond.text = ""
            binding.buttonThird.text = ""
            binding.buttonFourth.text = ""
            binding.buttonFifth.text = ""
            binding.buttonSixth.text = ""
            binding.buttonSeventh.text = ""
            binding.buttonEighth.text = ""
            binding.buttonNineth.text = ""

            xArray = arrayOf()
            oArray = arrayOf()
        }
    }

    private fun checkWin(forX: Boolean) {
        var data = xArray
        var text = "X win"

        if (!forX) {
            data = oArray
            text = "O win"
        }

        for (combination in winCombinations) {
            var array: Array<Boolean> = arrayOf()
            for (number in combination) {
                array += data.contains(number)
            }

            if (!array.contains(false) && array.isNotEmpty()) {
                binding.textviewSecond.text = text

                setButtonsEnabled(isEnabled = false)
                return
            }
        }
    }

    private fun setButtonsEnabled(isEnabled: Boolean) {
        binding.buttonFirst.isEnabled = isEnabled
        binding.buttonSecond.isEnabled = isEnabled
        binding.buttonThird.isEnabled = isEnabled
        binding.buttonFourth.isEnabled = isEnabled
        binding.buttonFifth.isEnabled = isEnabled
        binding.buttonSixth.isEnabled = isEnabled
        binding.buttonSeventh.isEnabled = isEnabled
        binding.buttonEighth.isEnabled = isEnabled
        binding.buttonNineth.isEnabled = isEnabled
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}