package study.step2

import java.lang.IllegalArgumentException

enum class OperatorEnum(val operator: String) {
    PLUS("+") {
        override fun process(): (a: Double, b: Double) -> Double {
            return { a: Double, b: Double -> a + b }
        }
    },
    MINUS("-") {
        override fun process(): (a: Double, b: Double) -> Double {
            return { a: Double, b: Double -> a - b }
        }
    },
    TIMES("*") {
        override fun process(): (a: Double, b: Double) -> Double {
            return { a: Double, b: Double -> a * b }
        }
    },
    DIVIDE("/") {
        override fun process(): (a: Double, b: Double) -> Double {
            return { a: Double, b: Double ->
                if (b == 0.0) {
                    throw IllegalArgumentException("분모는 0이 될 수 없습니다")
                }
                a / b
            }
        }
    };

    abstract fun process(): (a: Double, b: Double) -> Double

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

        fun findby(operator: String): OperatorEnum {
            OperatorEnum.values()
                .forEach { s ->
                    if (operator == s.operator) {
                        return s
                    }
                }
            throw IllegalArgumentException("해당하는 연산자 enum 을 찾을 수 없습니다")
        }
    }
}
