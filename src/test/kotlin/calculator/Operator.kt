package calculator

class Operator {
    companion object {
        val evaluate = { a: Float, b: Float, operator: String ->
            when (operator) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> a / b
                else -> throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
            }
        }
    }
}
