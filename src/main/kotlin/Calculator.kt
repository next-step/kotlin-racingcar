import java.util.LinkedList
import java.util.Queue

class Calculator {

    fun calculateExpression(expression: String?): Int {
        if (expression == null) throw IllegalArgumentException("입력 값이 null 입니다.")

        val num = StringBuilder()
        val (numList: Queue<Int>, operatorList) = LinkedList<Int>() to mutableListOf<Char>()
        for (index in expression.indices) {
            when {
                isEmpty(expression[index]) -> throw IllegalArgumentException("입력 값에 공백이 포함 되었습니다.")
                index == expression.lastIndex -> {
                    num.append(expression[index])
                    numList.add(num.toString().toInt())
                }
                isNumeric(expression[index]) -> num.append(expression[index])
                else -> {
                    numList.offer(num.toString().toInt())
                    num.clear()
                    operatorList.add(expression[index])
                }
            }
        }

        return calculate(numList, operatorList)
    }

    private fun isNumeric(operator: Char): Boolean = operator.toInt() in 48..57

    private fun isEmpty(value: Char): Boolean = value == ' '

    private fun calculate(
        numList: LinkedList<Int>,
        operatorList: MutableList<Char>
    ): Int {
        var result = numList.poll()
        for (operator in operatorList) {
            result = when (operator) {
                '+' -> result + numList.poll()
                '-' -> result - numList.poll()
                '*' -> result * numList.poll()
                '/' -> result / numList.poll()
                else -> throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
            }
        }
        return result
    }
}
