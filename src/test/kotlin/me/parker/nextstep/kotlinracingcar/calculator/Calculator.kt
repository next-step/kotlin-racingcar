package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.util.Strings

class Calculator {
    companion object {
        fun calculate(input: String): Int {
            val tokens = input.split("")
                .filter { !Strings.isNullOrEmpty(it) && it != " " }

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
