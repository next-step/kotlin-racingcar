package study

import java.util.regex.Pattern
import kotlin.jvm.Throws

open class Calculator(splitedStrings: String) {
    var splitedValues = listOf<String>()

    init {
        splitedValues = splitedStrings.split(" ")
        validate(splitedValues)
    }

    fun calculate(): Int {
        var resultValue = splitedValues.get(0).toInt()

        for (i in 1 until splitedValues.size step (2)) {
            val operator = splitedValues[i]
            val digit = splitedValues[i + 1].toInt()
            resultValue = apply(resultValue, digit, operator)
        }

        return resultValue
    }

    private fun apply(digit1: Int, digit2: Int, operator: String): Int {
        return when (operator) {
            "+" -> plus(digit1, digit2)
            "-" -> substract(digit1, digit2)
            "*" -> multiply(digit1, digit2)
            "/" -> divide(digit1, digit2)
            else -> 0
        }
    }

    fun validate(splitedValues: List<String>) {
        var operators = splitedValues.extracts(validDigitPattern, false)
        var digits = splitedValues.extracts(validDigitPattern, true)

        val blankCount = splitedValues.stream().filter { s -> s.isBlank() }.count().toInt()
        if (blankCount > 0 || operators.size == 0 || digits.size == 0
            || !operators.validate(validOperatorPattern) || !digits.validate(validDigitPattern)) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        var DIGITS_REGEX = "^[0-9]*$"
        var OPERATORS_REGEX = "[*+-/]"
        val validDigitPattern: Pattern = Pattern.compile(DIGITS_REGEX)
        val validOperatorPattern: Pattern = Pattern.compile(OPERATORS_REGEX)

        val plus = { x: Int, y: Int -> x + y }
        val substract = { x: Int, y: Int -> x - y }
        val multiply = { x: Int, y: Int -> x * y }
        val divide = { x: Int, y: Int -> x / y }
    }
}

fun List<String>.extracts(patterns: Pattern, match: Boolean): List<String> {
    val list = mutableListOf<String>()
    this.stream().forEach { a ->
        if (patterns.matcher(a).find() == match) {
            list.add(a)
        }
    }

    return list
}

@Throws(IllegalArgumentException::class)
fun List<String>.validate(patterns: Pattern): Boolean {
    return this.stream().allMatch { a -> patterns.matcher(a).find() }
}
