package calculator

@JvmInline
value class ArithmeticOperand(
    val value: Long,
) {

    operator fun plus(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(value + operand.value)
    }

    operator fun minus(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(value - operand.value)
    }

    operator fun times(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(value * operand.value)
    }

    operator fun div(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(value / operand.value)
    }

    companion object {
        fun of(stringValue: String): ArithmeticOperand {
            requireNotNull(stringValue.toLongOrNull()) { "사칙연산의 피연산자는 숫자여야합니다." }
            return ArithmeticOperand(stringValue.toLong())
        }
    }
}
