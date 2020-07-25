import java.util.LinkedList
import java.util.Queue

object Calculator {

    fun calEquation(equation: String?): Double {
        if (equation == null || equation.isEmpty()) {
            throw IllegalArgumentException("입력 값이 유효하지 않습니다.")
        }

        val (numList: Queue<Double>, operatorList) = LinkedList<Double>() to mutableListOf<Char>()
        separateNumAndOpList(equation, numList, operatorList)

        return calOperator(numList, operatorList)
    }

    fun calOperator(numList: LinkedList<Double>, operatorList: List<Char>): Double {
        var result = numList.poll()
        for (operator in operatorList) {
            result = when (operator) {
                Operator.PLUS.op -> Operator.PLUS.opCal(result, numList.poll())
                Operator.MINUS.op -> Operator.MINUS.opCal(result, numList.poll())
                Operator.MULTIPLE.op -> Operator.MULTIPLE.opCal(result, numList.poll())
                Operator.DIVIDE.op -> Operator.DIVIDE.opCal(result, numList.poll())
                else -> throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
            }
        }
        return result
    }

    private fun separateNumAndOpList(equation: String, numList: LinkedList<Double>, operatorList: MutableList<Char>) {
        val numBuilder = StringBuilder()

        for (index in equation.indices) {
            when {
                isEmpty(equation[index]) -> throw IllegalArgumentException("입력 값에 공백이 포함 되었습니다.")
                index == equation.lastIndex -> {
                    if (!isNumeric(equation[index])) {
                        throw IllegalArgumentException("완전하지 않은 식입니다.")
                    }
                    numBuilder.append(equation[index])
                    numList.add(numBuilder.toString().toDouble())
                }
                isNumeric(equation[index]) -> numBuilder.append(equation[index])
                else -> {
                    if (numBuilder.isEmpty()) {
                        throw IllegalArgumentException("완전하지 않은 식입니다.")
                    }
                    numList.offer(numBuilder.toString().toDouble())
                    numBuilder.clear()
                    operatorList.add(equation[index])
                }
            }
        }
    }

    private fun isNumeric(operator: Char): Boolean = operator.toInt() in 48..57

    private fun isEmpty(value: Char): Boolean = value == ' '
}
