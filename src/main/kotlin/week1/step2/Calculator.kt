package week1.step2

import java.util.LinkedList
import java.util.Queue

object Calculator {

    private const val ASCII_ZERO = 48
    private const val ASCII_NINE = 57
    private const val BLANK_CHARACTER = ' '

    private val NUMBER_RANGE = ASCII_ZERO..ASCII_NINE

    fun calculateFormula(formula: String?): Double {
        require(!formula.isNullOrEmpty()) {
            throw IllegalArgumentException("입력 값이 유효하지 않습니다.")
        }

        val (numberGroup: Queue<Double>, operatorGroup) = LinkedList<Double>() to mutableListOf<Operator>()
        separateNumAndOpList(formula, numberGroup, operatorGroup)

        return calculateOperator(numberGroup, operatorGroup)
    }

    fun calculateOperator(numberGroup: Queue<Double>, operatorGroup: List<Operator>): Double {
        var result = numberGroup.poll()
        for (operator in operatorGroup) {
            result = operator.opCal(result, numberGroup.poll())
        }
        return result
    }

    private fun separateNumAndOpList(
        formula: String,
        numberGroup: Queue<Double>,
        operatorGroup: MutableList<Operator>
    ) {
        val numBuilder = StringBuilder()

        for (index in formula.indices) {
            when {
                isBlank(formula[index]) -> throw IllegalArgumentException("입력 값에 공백이 포함 되었습니다.")
                index == formula.lastIndex -> {
                    if (!isNumeric(formula[index])) throw IllegalArgumentException("완전하지 않은 식입니다.")

                    numBuilder.append(formula[index])
                    numberGroup.add(numBuilder.toString().toDouble())
                }
                isNumeric(formula[index]) -> numBuilder.append(formula[index])
                else -> {
                    if (numBuilder.isEmpty()) throw IllegalArgumentException("완전하지 않은 식입니다.")

                    numberGroup.offer(numBuilder.toString().toDouble())
                    numBuilder.clear()
                    operatorGroup.add(convertCharToOp(formula[index]))
                }
            }
        }
    }

    private fun isNumeric(operator: Char): Boolean = operator.toInt() in NUMBER_RANGE

    private fun isBlank(value: Char): Boolean = value == BLANK_CHARACTER

    private fun convertCharToOp(op: Char): Operator {
        return when (op) {
            '+' -> Operator.PLUS
            '-' -> Operator.MINUS
            '*' -> Operator.MULTIPLE
            '/' -> Operator.DIVIDE
            else -> throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
        }
    }
}
