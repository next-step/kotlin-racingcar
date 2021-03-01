package step2

import java.lang.IllegalArgumentException

class Input {

    fun checkFormulaValidation(formula: String?): String {

        if (formula.isNullOrBlank()) {
            throw IllegalArgumentException("계산이 비었습니다.")
        }

        return formula
    }

    fun convertFormulaToList(formula: String): List<String> {
        return formula.split(" ")
            .filter { it.isNotBlank() }
    }
}
