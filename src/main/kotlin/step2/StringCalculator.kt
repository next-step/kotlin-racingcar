package com.dajeong.step2

import step2.operator.OperatorSelector
import step2.operator.removeRepeatedBlank

class StringCalculator(
    private val operatorSelector: OperatorSelector
) {
    fun calculate(string: String?): Double {
        validateNotBlank(string)

        val trimmedValue = string!!.removeRepeatedBlank()
        val elements = trimmedValue.split(" ")

        validateLength(elements)

        var result = elements[0].toDouble()
        for (i in 1 until elements.size step (2)) {
            val operatorString = elements[i]
            val targetNumberString = elements[i + 1]
            validateNumber(targetNumberString)
            result = operatorSelector.get(operatorString).operate(result, targetNumberString.toDouble())
        }
        return result
    }

    companion object StringValidator {
        fun validateNumber(targetNumber: String) {
            if (!targetNumber.matches(Regex("[0-9]+"))) {
                throw IllegalArgumentException("숫자 자리에 다른 문자가 입력되었습니다.")
            }
        }

        fun validateNotBlank(string: String?) {
            if (string == null) {
                throw IllegalArgumentException("입력값이 null 입니다. 올바른 값을 입력해주세요.")
            }
            if (string.isBlank()) {
                throw IllegalArgumentException("입력값이 비어있습니다. 올바른 값을 입력해주세요.")
            }
        }

        fun validateLength(split: List<String>) {
            if (split.size < 3) {
                throw IllegalArgumentException("계산할 숫자와 연산자가 충분하지 않습니다.")
            }
            if (split.size % 2 == 0) {
                throw IllegalArgumentException("숫자 또는 연산자가 누락되었습니다.")
            }
        }
    }
}