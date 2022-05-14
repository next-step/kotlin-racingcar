package step2

class Calculator {
    fun calculate(inputString: String): String {
        val splitList = inputString.split(" ")
        var result = splitList[0].toInt()

        for (index in 1 until splitList.size step 2) {
            result = when (splitList[index]) {
                "+" -> result + splitList[index + 1].toInt()
                "-" -> result - splitList[index + 1].toInt()
                else -> throw IllegalArgumentException()
            }
        }

        return result.toString()
    }
}
