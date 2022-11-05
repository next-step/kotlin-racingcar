package com.jay.calculator

import java.lang.IllegalArgumentException

object StringCalculator {
    fun calculate(input: String?): Int {
        validate(input)
        val split = input!!.split(" ")
        var result: Int = toInt(split[0])
        for (i in 1 until split.size step 2) {
            result = Operand.symbolOf(split[i]).apply(result, toInt(split[i + 1]))
        }
        return result
    }

    private fun validate(input: String?) {
        require(!input.isNullOrEmpty()) { "input cannot be empty or null" }
    }

    private fun toInt(input: String) = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("invalid input - $input")
    }
}
