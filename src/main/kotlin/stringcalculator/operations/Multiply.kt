package stringcalculator.operations

class Multiply : Operation {
    override fun execute(operationalNums: ArrayDeque<Int>) {
        val (leftNum, rightNum) = popFirstTwo(operationalNums)
        operationalNums.addFirst(leftNum * rightNum)
    }
}
