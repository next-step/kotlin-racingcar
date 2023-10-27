package calculator

class StringExpressionOperand(
    val number: Int
) {
    constructor(number: String) : this(number.toInt())

    operator fun plus(operand: StringExpressionOperand): StringExpressionOperand {
        return StringExpressionOperand(number + operand.number)
    }

    operator fun minus(operand: StringExpressionOperand): StringExpressionOperand {
        return StringExpressionOperand(number - operand.number)
    }

    operator fun times(operand: StringExpressionOperand): StringExpressionOperand {
        return StringExpressionOperand(number * operand.number)
    }

    operator fun div(operand: StringExpressionOperand): StringExpressionOperand {
        return StringExpressionOperand(number / operand.number)
    }
}
