package me.parker.nextstep.kotlinracingcar.calculator

enum class OperatorType(val symbol: String, val calculate: (Int, Int) -> Int) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        a / b
    });

    companion object {
        fun calculate(operator: String, lValue: Int, rValue: Int): Int {
            return OperatorType.from(operator).calculate(lValue, rValue)
        }

        private fun from(operator: String): OperatorType {
            return values().find { it.symbol == operator }
                ?: throw IllegalArgumentException("올바르지 않은 연산자입니다.")
        }

        fun exist(operator: String): Boolean {
            return values().any { it.symbol == operator }
        }
    }
}