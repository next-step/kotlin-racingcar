package step2

import step2.OperationsManager.Constants.VALID_OPERATOR_LIST
import java.lang.IllegalArgumentException

class InputManager {

    fun convertFormulaToList(formula: String?): List<String>? {
        if (isContainNullOrBlank(formula)) {
            throw IllegalArgumentException()
        }
        if (isContainWrongOperator(formula)) {
            throw IllegalArgumentException()
        }

        return formula!!.split(" ")
    }

    fun isContainNullOrBlank(formula: String?): Boolean {
        return formula.isNullOrBlank()
    }

    fun isContainWrongOperator(formula: String?): Boolean {
        formula?.forEach { char ->
            if (!char.isDigit() && !VALID_OPERATOR_LIST.contains(char) && char != ' ') {
                return true
            }
        }
        return false
    }
}
