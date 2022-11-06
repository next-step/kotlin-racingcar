package step2

import kotlin.IllegalArgumentException

class StringCalculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrEmpty())
        val inputArray = input.split(" ")
        var result = inputArray[0].toInt()

        for (i in 2 until inputArray.size step 2) {
            val calculateOperator = Operator.from(inputArray[i - 1])
            result = calculateOperator.calculate(result, inputArray[i].toInt())
        }

        return result
    }
}
