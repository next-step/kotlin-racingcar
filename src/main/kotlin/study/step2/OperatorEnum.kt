package study.step2

import java.lang.IllegalArgumentException

enum class OperatorEnum(val operator: String) {
    PLUS("+") {
        override fun process(): (a: Int, b: Int) -> Int {
            return { a: Int, b: Int -> a + b }
        }
    },
    MINUS("-") {
        override fun process(): (a: Int, b: Int) -> Int {
            return { a: Int, b: Int -> a - b }
        }
    },
    TIMES("*") {
        override fun process(): (a: Int, b: Int) -> Int {
            return { a: Int, b: Int -> a * b }
        }
    },
    DIVIDE("/") {
        override fun process(): (a: Int, b: Int) -> Int {
            return { a: Int, b: Int ->
                if (b == 0) {
                    throw IllegalArgumentException("분모는 0이 될 수 없습니다")
                }
                a / b
            }
        }
    };

    abstract fun process(): (a: Int, b: Int) -> Int

    companion object {
        fun exist(operator: String): Boolean {
            OperatorEnum.values()
                .forEach { s ->
                    if (operator == s.operator) {
                        return true
                    }
                }
            return false
        }

        fun findByOrNull(operator: String): OperatorEnum? {
            return OperatorEnum.values().find { operator == it.operator }
        }
    }
}
