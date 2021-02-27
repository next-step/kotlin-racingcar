package step2

import java.lang.IllegalArgumentException

class Input {

    fun checkFormulaValidation(formula: String?): String {

        when {
            formula == null -> {
                throw IllegalArgumentException("계산이 비었습니다.")
            }
            formula.isBlank() -> {
                throw IllegalArgumentException("계산식은 공백일 수 없습니다.")
            }
            formula.isEmpty() -> {
                throw IllegalArgumentException("빈 값이 입력됐습니다.")
            }
        }

        return formula!!
    }

    fun convertFormulaToList(formula: String): List<String> {
        return formula.split(" ")
            .filter { it.isNotBlank() }
    }
}
