package stringcalculator

enum class Operation(
    val sign: String,
    val calculate: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTI("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        require(a != 0 || b != 0) { "0으로 나눌 수 없습니다." }
        a / b
    });

    companion object {
        fun of(sign: String): Operation {
            val matchedValue = values().find { operation -> operation.sign == sign }
            requireNotNull(matchedValue) { "사칙연산 문자만 가능합니다." }
            return matchedValue
        }
    }
}
