package calculator.domain

data class Operand(val value: Int) {

    fun sum(operand: Operand): Operand {
        return Operand(value + operand.value)
    }

    fun subtract(operand: Operand): Operand {
        return Operand(value - operand.value)
    }

    fun multiply(operand: Operand): Operand {
        return Operand(value * operand.value)
    }

    fun divide(operand: Operand): Operand {
        return Operand((value / operand.value))
    }
}
