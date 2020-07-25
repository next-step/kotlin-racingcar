import java.util.LinkedList
import java.util.Queue

object Calculator {

    fun calEquation(equation: String?): Int {
        if (equation == null) throw IllegalArgumentException("입력 값이 null 입니다.")

        val num = StringBuilder()
        val (numList: Queue<Int>, operatorList) = LinkedList<Int>() to mutableListOf<Char>()
        for (index in equation.indices) {
            when {
                isEmpty(equation[index]) -> throw IllegalArgumentException("입력 값에 공백이 포함 되었습니다.")
                index == equation.lastIndex -> {
                    if (!isNumeric(equation[index])) {
                        throw IllegalArgumentException("완전하지 않은 식입니다.")
                    }
                    num.append(equation[index])
                    numList.add(num.toString().toInt())
                }
                isNumeric(equation[index]) -> num.append(equation[index])
                else -> {
                    numList.offer(num.toString().toInt())
                    num.clear()
                    operatorList.add(equation[index])
                }
            }
        }

        return calOperator(numList, operatorList)
    }

    private fun isNumeric(operator: Char): Boolean = operator.toInt() in 48..57

    private fun isEmpty(value: Char): Boolean = value == ' '

    private fun calOperator(
        numList: LinkedList<Int>,
        operatorList: MutableList<Char>
    ): Int {
        var result = numList.poll()
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
}
