package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

class StringCalculator {
    companion object {
        fun calculate(input: String): Int {
            if (Strings.isNullOrEmpty(input))
                throw IllegalArgumentException("입력값이 비어있습니다.")

            val tokens: List<String> = separateOperandAndOperator(input)

            var result = tokens[0].toInt()
            var operator = ""
            for ((index, token) in tokens.withIndex()) {
                if (index == 0) continue

                if (isNumber(token))
                    result = OperatorType.calculate(operator, result, token.toInt())
                else
                    operator = token
            }

            return result
        }

        private fun separateOperandAndOperator(input: String): List<String> {
            val tokens = input.split("")
                .filter { !Strings.isNullOrEmpty(it) && it != " " }

            val results = mutableListOf<String>()

            var number = ""
            for (token in tokens) {
                if (isNumber(token)) {
                    number += token
                }

                if (isNumber(token).not() && number.isNotEmpty()) {
                    results.add(number)
                    number = ""
                }

                if (isNumber(token).not()) {
                    results.add(token)
                }
            }
            results.add(number)

            if (isValidFormulaOrder(results).not())
                throw IllegalArgumentException("계산식이 올바르지 않습니다.")

            return results
        }

        private fun isValidFormulaOrder(arguments: MutableList<String>): Boolean {
            for ((index, arg) in arguments.withIndex()) {
                if (index % 2 == 0 && isNumber(arg).not())
                    return false
                if (index % 2 != 0 && OperatorType.of(arg).not())
                    return false

                if (index < arguments.size - 1 && isNumber(arg) && isNumber(arguments[index + 1]))
                    return false
            }

            return arguments.size > 1
        }

        private fun isNumber(str: String): Boolean {
            return try {
                str.toInt()
                true
            } catch (e: NumberFormatException) {
                false
            }
        }
    }
}
