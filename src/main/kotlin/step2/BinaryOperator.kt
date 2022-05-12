package step2

object BinaryOperator {
    fun getOperator(s: String): (Double, Double) -> Double {
        return when (s) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            "*" -> { x, y -> x * y }
            "/" -> { x, y -> x / y }
            else -> throw IllegalArgumentException("알 수 없는 연산자입니다.")
        }
    }
}