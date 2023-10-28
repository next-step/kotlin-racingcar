package main

import calculator.Calculator

class StringCalculator {
    fun run(formula: String?): Int {
        val trimmed = formula?.trim()
        if (trimmed.isNullOrEmpty()) throw IllegalArgumentException("Formula should not be null or empty")

        val tokens = trimmed.split(" ")
        var result = tokens.first().toInt()
        for (i in 1 until tokens.size step 2) {
            result = Calculator().calculate(a = result, op = tokens[i], b = tokens[i + 1].toInt())
        }

        return result
    }
}
