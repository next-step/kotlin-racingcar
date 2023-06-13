package study.calculator

object Calculator {
    fun calculate(question: String?): Int {
        if (question.isNullOrEmpty()) throw IllegalArgumentException("question was null or empty.")

        val splits = question.split(" ")
        var result = splits[0].toInt()

        for (i in 1 until splits.size step 2) {
            CalculatorOperator.operator(splits[i])
                .calculate(result, splits[i + 1].toInt())
                .run { result = this }
        }

        return result
    }
}
