package step2

import java.lang.IllegalArgumentException

class Input {

    fun inputFormula(): String {

        val formula = readLine()
        if (formula.isNullOrBlank()) throw IllegalArgumentException()

        return formula
    }

    fun convertFormulaToList(formula: String): List<String> {
        return formula.split(" ")
            .filter { it.isNotBlank() }
    }
}
