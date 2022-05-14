package step2

class Calculator {
    fun calculate(inputString: String): Double {
        val splitList = inputString.split(" ")
        var result = splitList[0].toDouble()

        for (index in 1 until splitList.size step 2) {
            result = when (splitList[index]) {
                "+" -> result + splitList[index + 1].toDouble()
                "-" -> result - splitList[index + 1].toDouble()
                "*" -> result * splitList[index + 1].toDouble()
                "/" -> result / splitList[index + 1].toDouble()
                else -> throw IllegalArgumentException()
            }
        }

        return result
    }
}
