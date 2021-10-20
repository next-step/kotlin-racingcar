package stringcalculator.operations

data class Operational(val leftNum: Int, val rightNum: Int)

interface Operation {
    fun execute(operationalNums: ArrayDeque<Int>)

    @Throws(NoSuchElementException::class)
    fun Operation.popFirstTwo(operationalNums: ArrayDeque<Int>): Operational {
        val leftNum = operationalNums.removeFirst()
        val rightNum = operationalNums.removeFirst()
        return Operational(leftNum, rightNum)
    }
}
