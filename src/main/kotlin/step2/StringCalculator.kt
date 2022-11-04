package step2

import java.lang.IllegalArgumentException

class StringCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) throw IllegalArgumentException()

        val inputArray = input.split(" ")
        var result = inputArray[0].toInt()

        for (i in 2 until inputArray.size step 2) {
            val operator = Operator.from(inputArray[i - 1]) ?: throw IllegalArgumentException()
            result = operator.apply(result, inputArray[i].toInt())
        }

        return result
    }
}
