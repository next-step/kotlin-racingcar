package calculator

class StringCalculator {

    companion object {
        private const val FOREACH_STEP_NUMBER = 2
        private const val FOREACH_START_NUMBER = 1
        private const val ADD_NUMBER = 1
        private const val COLLECTION_FIRST_NUMBER = 0
    }

    fun calculation(inputValue: String): Int {
        val splitList = Value(inputValue).value

        var result = valueToInt(splitList[COLLECTION_FIRST_NUMBER])
        for (i in FOREACH_START_NUMBER until splitList.count() step (FOREACH_STEP_NUMBER)) {
            result = confirmFourArithmetic(splitList[i], Pair(result, valueToInt(splitList[i + ADD_NUMBER])))
        }

        return result
    }

    private fun valueToInt(inputValue: String) = inputValue.toInt()
}
