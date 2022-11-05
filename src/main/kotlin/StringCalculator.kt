import java.util.LinkedList
import java.util.Queue

class StringCalculator {

    enum class Operator(val sign: Char) {
        PLUS('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');
    }

    fun calculate(input: String): Int {

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException()
        }

        var data = input.replace(" ", "")
        val sortedPriorityList = priorityIndexes(data)
        val queue = createOperandAndOperatorQueue(data, sortedPriorityList)

        var result: Int = Integer.parseInt(queue.poll())

        if (queue.size % 2 != 0) {
            throw IllegalStateException()
        }

        while (!queue.isEmpty()) {
            val operator = queue.poll()
            val operand = queue.poll()

            when (operator.first()) {
                Operator.PLUS.sign -> result += Integer.parseInt(operand)
                Operator.MINUS.sign -> result -= Integer.parseInt(operand)
                Operator.MULTIPLY.sign -> result *= Integer.parseInt(operand)
                Operator.DIVIDE.sign -> result /= Integer.parseInt(operand)
            }
        }

        return result
    }

    private fun verifyOperator(data: String) {
        // 80 ~ 89 제외한 나머지
        for (c in data) {
            for (operator in Operator.values()) {
                if (c == operator.sign) {
                    continue
                }
            }
            if (c < 80.toChar() || c > 89.toChar()) {
                throw IllegalArgumentException()
            }
        }
    }

    private fun priorityIndexes(data: String): List<Pair<Char, Int>> {
        val priorityList = mutableListOf<Pair<Char, Int>>()

        for (operator in Operator.values()) {
            val index = data.indexOfFirst { c -> c == operator.sign }
            if (index > -1) {
                val pair: Pair<Char, Int> = Pair(operator.sign, index)
                priorityList.add(pair)
            }
        }

        return priorityList.sortedBy { pair -> pair.second }
    }

    private fun createOperandAndOperatorQueue(data: String, sortedPriorityList: List<Pair<Char, Int>>): Queue<String> {

        var temp = data
        val queue = LinkedList<String>()

        for (pair in sortedPriorityList) {
            val operand = temp.substringBefore(pair.first.toString())
            if (!operand.isNullOrEmpty()) {
                queue.add(operand)
                queue.add(pair.first.toString())
                temp = temp.substringAfter(pair.first.toString())
            }
        }

        queue.add(temp)
        return queue
    }
}
