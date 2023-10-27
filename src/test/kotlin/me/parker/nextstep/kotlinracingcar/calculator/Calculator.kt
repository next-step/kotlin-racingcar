package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

class Calculator {
    companion object {
        fun calculate(input: String): Int {
            if (Strings.isNullOrEmpty(input))
                throw IllegalArgumentException("입력값이 비어있습니다.")

            val tokens: List<String> = separateNumAndOperator(input)

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

        private fun separateNumAndOperator(input: String): List<String> {
            val tokens = input.split("")
                .filter { !Strings.isNullOrEmpty(it) && it != " " }

            var results = mutableListOf<String>()

            var number = ""
            for (token in tokens) {
                if (isNumber(token)) {
                    number += token
                } else {
                    results.add(number)
                    number = ""

                    results.add(token)
                }
            }
            results.add(number)

            return results
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
