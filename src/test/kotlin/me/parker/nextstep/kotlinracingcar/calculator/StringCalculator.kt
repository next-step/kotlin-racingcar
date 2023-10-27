package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

class StringCalculator {
    companion object {
        private const val EMPTY_STRING = ""

        fun calculate(input: String): Int {
            if (Strings.isNullOrEmpty(input))
                throw IllegalArgumentException("입력값이 비어있습니다.")

            val tokens: List<String> = separateOperandAndOperator(input)

            return calculateFormula(tokens)
        }

        private fun calculateFormula(formulaTokens: List<String>): Int {
            var result = formulaTokens[0].toInt()
            for ((index, token) in formulaTokens.withIndex()) {
                if (index == 0) continue

                if (isEvenNumber(index)) {
                    val operator = formulaTokens[index - 1]
                    result = OperatorType.calculate(operator, result, token.toInt())
                }
            }

            return result
        }

        private fun separateOperandAndOperator(input: String): List<String> {
            val tokens = input.split(EMPTY_STRING)
                .filter { !Strings.isNullOrEmpty(it) && it != " " }

            val results = mutableListOf<String>()

            var number = EMPTY_STRING
            for (token in tokens) {
                if (isNumber(token)) {
                    number += token
                }

                if (isNumber(token).not() && number.isNotEmpty()) {
                    results.add(number)
                    number = EMPTY_STRING
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
                if (isEvenNumber(index) && isNumber(arg).not())
                    return false
                if (isEvenNumber(index).not() && OperatorType.exist(arg).not())
                    return false

                if (index < arguments.size - 1 && isNumber(arg) && isNumber(arguments[index + 1]))
                    return false
            }

            return arguments.size > 1
        }

        private fun isEvenNumber(num: Int) = num % 2 == 0

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
