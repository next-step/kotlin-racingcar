package calculator

enum class Operator(
    private val sign: String,
    private val calculation: (CalculatorNumber, CalculatorNumber) -> CalculatorNumber
) {
    ADDITION("+", { a, b -> CalculatorNumber(a.value + b.value) }),
    SUBTRACTION("-", { a, b -> CalculatorNumber(a.value - b.value) }),
    MULTIPLICATION("*", { a, b -> CalculatorNumber(a.value * b.value) }),
    DIVISION("/", { a, b -> CalculatorNumber(a.value / b.value) }),
    ;

    fun calculate(a: CalculatorNumber, b: CalculatorNumber): CalculatorNumber = calculation(a, b)

    companion object {
        fun findBySign(sign: String): Operator {
            return values().find { it.sign == sign }
                ?: throw IllegalArgumentException("$sign 에 해당하는 연산자를 찾지 못했습니다.")
        }
    }
}
