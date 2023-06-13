package study.calculator

object Calculator {
    fun calculate(question: String?): Int {
        if (question.isNullOrEmpty()) throw IllegalArgumentException("question was null or empty.")

        val splits = question.split(" ")
        var result = splits[0].toInt()

        splits.forEachIndexed { index, s ->
            when (s) {
                "+" -> plus(result, splits[index + 1].toInt())
                "-" -> minus(result, splits[index + 1].toInt())
                "*" -> multiple(result, splits[index + 1].toInt())
                "/" -> divider(result, splits[index + 1].toInt())
                else -> {
                    s.toIntOrNull() ?: throw IllegalArgumentException("question allows only integer or +, -, * and /.")
                    result
                }
            }.let { result = it }
        }

        return result
    }

    private fun plus(num1: Int, num2: Int) = num1 + num2

    private fun minus(num1: Int, num2: Int) = num1 - num2

    private fun multiple(num1: Int, num2: Int) = num1 * num2

    private fun divider(num1: Int, num2: Int) = num1 / num2
}
