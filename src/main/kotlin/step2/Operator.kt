package step2

import java.lang.IllegalArgumentException

enum class Operator(
    val label: String,
    val execute: (a: Int, b: Int) -> Int,
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLE("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) {
            throw IllegalStateException("0 으로 숫자를 나눌 수 없습니다.")
        }
        a / b
    })
    ;

    companion object {
        fun getByLabel(label: String): Operator {
            return Operator.values().find { it.label == label }
                ?: throw IllegalArgumentException("연산 기호는 +, -, *, / 만 입력할 수 있습니다.")
        }

        fun existsByLabel(label: String): Boolean {
            return Operator.values().any { it.label == label }
        }
    }
}
