package stringArithmeticCalculator

enum class StringArithmetic(val arithmetic: String, val func: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    MODULUS("/", { a, b -> if (b == 0) throw ArithmeticException("0으로는 나눠지지가 않습니다.") else a / b });

    fun calculate(currentNumber: Int, nextNumber: Int) = this.func(currentNumber, nextNumber)

    companion object {
        fun from(arithmetic: String, nextNumber: Int, currentNumber: Int) =
            values().find { value -> value.arithmetic == arithmetic }?.calculate(currentNumber, nextNumber)
                ?: throw IllegalArgumentException("잘못 된 사칙연산입니다.")
    }
}
