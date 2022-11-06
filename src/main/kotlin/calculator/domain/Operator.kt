package calculator.domain

enum class Operator(
    private val value: String,
) : Calculable {
    PLUS("+") {
        override fun calculate(number1: Operand, number2: Operand): Operand {
            return Operand(number1.plus(number2))
        }
    },
    MINUS("-") {
        override fun calculate(number1: Operand, number2: Operand): Operand {
            return Operand(number1.minus(number2))
        }
    },
    MULTIPLE("*") {
        override fun calculate(number1: Operand, number2: Operand): Operand {
            return Operand(number1.multiply(number2))
        }
    },
    DIVIDE("/") {
        override fun calculate(number1: Operand, number2: Operand): Operand {
            return Operand(number1.div(number2))
        }
    };

    companion object {
        fun from(operator: String): Operator {
            return values()
                .find { it.value == operator } ?: throw IllegalArgumentException("올바르지 않은 연산자 입니다")
        }
    }
}