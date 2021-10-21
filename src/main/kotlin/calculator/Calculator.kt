package calculator

object Calculator {
    fun calculate(formula: String?): Int {
        if (formula.isNullOrBlank()) {
            throw IllegalArgumentException("null 또는 공백을 입력할 수 없습니다.")
        }
        val split = formula.split(" ")
        var result = split[0].toInt()
        for (i: Int in 1 until split.size step (2)) {
            val operator = split[i]
            val target = split[i + 1].toInt()
            result = Operator(result, target, operator).operate()
        }
        return result
    }
}
