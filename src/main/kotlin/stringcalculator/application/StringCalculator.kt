package stringcalculator.application

import step2.operator.removeRepeatedBlank
import stringcalculator.operator.OperatorSelector
import stringcalculator.util.StringValidator

class StringCalculator(
    private val operatorSelector: OperatorSelector
) {
    fun calculate(string: String?): Double {
        StringValidator.validateNotBlank(string)

        val trimmedValue = string!!.removeRepeatedBlank()
        val elements = trimmedValue.split(" ")

        validateLength(elements)

        var result = elements[0].toDouble()
        for (i in 1 until elements.size step (2)) {
            val operatorString = elements[i]
            val targetNumberString = elements[i + 1]
            StringValidator.validateNumber(targetNumberString)
            result = operatorSelector.get(operatorString).operate(result, targetNumberString.toDouble())
        }
        return result
    }

    companion object ArgumentsValidator {

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
