import java.util.LinkedList
import java.util.Queue

class StringCalculator {

    fun calculate(input: String): Int {

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException()
        }

        var data = input.replace(" ", "")
        verifyOperator(data)
        val sortedPriorityList = priorityIndexes(data)
        val queue = createOperandAndOperatorQueue(data, sortedPriorityList)

        var result: Int = Integer.parseInt(queue.poll())

        if (queue.size % 2 != 0) {
            throw IllegalStateException()
        }

        while (!queue.isEmpty()) {
            val operator = queue.poll()
            val operand = queue.poll()

            val o = Operator(operator.first())
            result = o.calculate(result, Integer.parseInt(operand))
        }

        return result
    }

    private fun verifyOperator(data: String) {
        for (c in data) {
            var isOperator = false
            for (operator in Operator.values()) {
                if (operator.equals(c)) {
                    isOperator = true
                }
            }
            if (!isOperator && (c < 48.toChar() || c > 57.toChar())) {
                throw IllegalArgumentException()
            }
        }
    }

    private fun priorityIndexes(data: String): List<Pair<Char, Int>> {
        val priorityList = mutableListOf<Pair<Char, Int>>()

        for (operator in Operator.values()) {
            val index = data.indexOfFirst { c -> operator.equals(c) }
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
