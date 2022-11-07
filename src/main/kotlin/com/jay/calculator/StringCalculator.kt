package com.jay.calculator

import java.lang.IllegalArgumentException

object StringCalculator {
    private const val FIRST_VALUE = 1
    private const val NUMBER_TARGET_INDEX = 2
    private const val DELIMITER = " "
    fun calculateDelimiters(input: String?): Int {
        val delimiter = splitIntoSingleArgs(input)
        return calculateDelimiters(delimiter)
    }

    private fun calculateDelimiters(delimiter: List<String>): Int {
        var result: Int = toInt(delimiter.first())
        for (i in FIRST_VALUE until delimiter.size step NUMBER_TARGET_INDEX) {
            result = Operand.symbolOf(delimiter[i]).apply(result, toInt(delimiter[i + FIRST_VALUE]))
        }
        return result
    }

    private fun splitIntoSingleArgs(input: String?): List<String> {
        require(!input.isNullOrEmpty()) { "input cannot be empty or null" }
        return input.split(DELIMITER)
    }

    private fun toInt(input: String) = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("invalid input - $input")
    }
}
