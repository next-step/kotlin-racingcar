
object Calculator {

    private const val SPERATOR = " "
    private const val LAST_INDEX = 1
    private const val NEXT_PART_INDEX = 2
    private const val NUMBER_POSITION = 0
    private const val OPERATOR_POSITION = 1

    fun calculate(formulaString: String): String {
        if (formulaString.isEmpty()) {
            throw IllegalArgumentException("Input value is empty")
        }
        val formulaList = formulaString.split(SPERATOR)
        val resultValue = recursiveCalculator(formulaList.reversed())
        println(resultValue)
        return resultValue
    }

    private fun recursiveCalculator(formulaList: List<String>): String {
        return if (formulaList.size == LAST_INDEX) {
            formulaList[NUMBER_POSITION]
        } else {
            Operator.getOperator(formulaList[OPERATOR_POSITION]).calculate(recursiveCalculator(formulaList.drop(NEXT_PART_INDEX)), formulaList[NUMBER_POSITION])
        }
    }
}
