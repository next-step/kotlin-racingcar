package stringcalculator.operations

class Add : Operation {
    override fun execute(operationalNums: ArrayDeque<Int>) {
        val (leftNum, rightNum) = popFirstTwo(operationalNums)
        operationalNums.addFirst(leftNum + rightNum)
    }
}
