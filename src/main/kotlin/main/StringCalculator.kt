package main

import calculator.Calculator

class StringCalculator {
    fun run(formula: String?): Int {
        if (formula.isNullOrBlank()) throw IllegalArgumentException("Formula should not be null or empty")

        val tokens = formula.split(" ")
        var result = tokens.first().toInt()
        for (i in 1 until tokens.size step 2) {
            result = Calculator[tokens[i]].operation(a = result, b = tokens[i + 1].toInt())
        }

        return result
    }
}
