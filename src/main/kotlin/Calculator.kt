import java.util.LinkedList
import java.util.Queue

object Calculator {

    fun calEquation(equation: String?): Double {
        if (equation == null || equation.isEmpty()) {
            throw IllegalArgumentException("입력 값이 유효하지 않습니다.")
        }

        val (numList: Queue<Int>, operatorList) = LinkedList<Int>() to mutableListOf<Char>()
        separateNumAndOpList(equation, numList, operatorList)

        return calOperator(numList, operatorList)
    }

    fun calOperator(numList: LinkedList<Int>, operatorList: List<Char>): Double {
        var result = numList.poll().toDouble()
        for (operator in operatorList) {
            result = when (operator) {
                '+' -> result + numList.poll()
                '-' -> result - numList.poll()
                '*' -> result * numList.poll()
                '/' -> {
                    val operand = numList.poll()
                    if (operand == 0) throw ArithmeticException("0으로 나눌 수 없습니다.")
                    result / operand
                }
                else -> throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
            }
        }
        return result
    }

    private fun separateNumAndOpList(equation: String, numList: LinkedList<Int>, operatorList: MutableList<Char>) {
        val numBuilder = StringBuilder()

        for (index in equation.indices) {
            when {
                isEmpty(equation[index]) -> throw IllegalArgumentException("입력 값에 공백이 포함 되었습니다.")
                index == equation.lastIndex -> {
                    if (!isNumeric(equation[index])) {
                        throw IllegalArgumentException("완전하지 않은 식입니다.")
                    }
                    numBuilder.append(equation[index])
                    numList.add(numBuilder.toString().toInt())
                }
                isNumeric(equation[index]) -> numBuilder.append(equation[index])
                else -> {
                    if (numBuilder.isEmpty()) {
                        throw IllegalArgumentException("완전하지 않은 식입니다.")
                    }
                    numList.offer(numBuilder.toString().toInt())
                    numBuilder.clear()
                    operatorList.add(equation[index])
                }
            }
        }
    }

    private fun isNumeric(operator: Char): Boolean = operator.toInt() in 48..57

    private fun isEmpty(value: Char): Boolean = value == ' '
}
