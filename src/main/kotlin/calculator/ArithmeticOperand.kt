package calculator

@JvmInline
value class ArithmeticOperand(
    private val _value: Long,
) {

    val value: Long
        get() = _value

    operator fun plus(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(_value + operand._value)
    }

    operator fun minus(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(_value - operand._value)
    }

    operator fun times(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(_value * operand._value)
    }

    operator fun div(operand: ArithmeticOperand): ArithmeticOperand {
        return ArithmeticOperand(_value / operand._value)
    }

    companion object {
        fun of(stringValue: String): ArithmeticOperand {
            requireNotNull(stringValue.toLongOrNull()) { "사칙연산의 피연산자는 숫자여야합니다." }
            return ArithmeticOperand(stringValue.toLong())
        }
    }
}
