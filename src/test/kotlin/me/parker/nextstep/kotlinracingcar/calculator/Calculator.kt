package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

class Calculator {
    companion object {
        fun calculate(input: String): Int {
            if (Strings.isNullOrEmpty(input))
                throw IllegalArgumentException("입력값이 비어있습니다.")

            val tokens: List<String> = separateOperandAndOperator(input)

            var result = tokens[0].toInt()
            var operator = ""
            for ((index, token) in tokens.withIndex()) {
                if (index == 0) continue

                if (isNumber(token)) {
                    result = calculate(result, operator, token.toInt())
                } else {
                    operator = token
                }
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
                } else {
                    results.add(number)
                    number = ""

                    if (isValidOperator(token).not())
                        throw IllegalArgumentException("계산식이 올바르지 않습니다.")

                    results.add(token)
                }
            }
            results.add(number)

            if (isValidFormula(results).not())
                throw IllegalArgumentException("계산식이 올바르지 않습니다.")

            return results
        }

        private fun isValidOperator(token: String): Boolean {
            return token == "+" || token == "-" || token == "*" || token == "/"
        }

        private fun isValidFormula(arguments: MutableList<String>): Boolean {
            for ((index, arg) in arguments.withIndex()) {
                if (index % 2 == 0 && isNumber(arg).not()) {
                    return false
                }
                if (index % 2 != 0 && isValidOperator(arg).not()) {
                    return false
                }

                if (index < arguments.size - 1 && isNumber(arg) && isNumber(arguments[index + 1])) {
                    return false
                }
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

        private fun calculate(left: Int, operator: String, right: Int): Int {
            return when (operator) {
                "+" -> {
                    left + right
                }

                "-" -> {
                    left - right
                }

                "*" -> {
                    left * right
                }

                "/" -> {
                    left / right
                }

                else -> throw IllegalArgumentException("잘못된 연산자입니다. input operator = $operator")
            }
        }
    }
}
