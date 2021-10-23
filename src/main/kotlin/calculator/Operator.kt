package calculator

class Operator(private val operator: String) {

    fun operate(base: Int, target: Int): Int {
        return when (operator) {
            "+" -> base + target
            "-" -> base - target
            "*" -> base * target
            "/" -> base / target
            else -> throw IllegalArgumentException("잘못된 사칙연산입니다.")
        }
    }
}
