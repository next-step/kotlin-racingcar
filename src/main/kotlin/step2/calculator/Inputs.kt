package step2.calculator

import step2.calculator.vo.CalculatorInput
import step2.calculator.vo.Number
import step2.calculator.vo.Operation

class Inputs(
    private val numbers: List<Number>,
    private val operations: List<Operation>,
) {
    private var numbersPosition: Int = 0
    private var operationsPosition: Int = 0

    val hasNextNumberPair: Boolean
        get() {
            return numbers.size < numbersPosition
        }

    val nextNumberP: Number
        get() {
            val result = numbers[numbersPosition]
            numbersPosition += 1

            return result
        }

    val hasNextOperation: Boolean
        get() {
            return operations.size < operationsPosition
        }

    val nextOperation: Operation
        get() {
            val result = operations[operationsPosition]
            operationsPosition += 1

            return result
        }

    companion object
}

@Suppress("UNCHECKED_CAST")
fun Inputs.Companion.from(values: List<CalculatorInput>): Inputs {
    values.validateFormat()

    val groupBy = values.groupBy { it.getType() }

    return Inputs(
        groupBy[Number::class.java] as List<Number>,
        groupBy[Operation::class.java] as List<Operation>
    )
}

private fun List<CalculatorInput>.validateFormat() {
    validateNumberPosition()
    validateOperationOption()
    validateOperandCount()
    validateInputLength()
}

private fun List<CalculatorInput>.validateNumberPosition() {
    for (i: Int in 0 until this.size step (2)) {
        if (this[i] !is Number) {
            throw IllegalArgumentException("인풋 포멧 오류")
        }
    }
}

private fun List<CalculatorInput>.validateOperationOption() {
    for (i: Int in 1 until this.size step (2)) {
        if (this[i] !is Operation) {
            throw IllegalArgumentException("인풋 포멧 오류")
        }
    }
}

private fun List<CalculatorInput>.validateOperandCount() {
    val groupBy = this.groupingBy {
        it.getType()
    }.eachCount()

    if (groupBy[Number::class.java] != groupBy[Operation::class.java]?.plus(1)) {
        throw IllegalArgumentException("피연산자 오류")
    }
}

private fun List<CalculatorInput>.validateInputLength() {
    if (this.size < 3) {
        throw IllegalArgumentException("인풋 포멧 오류")
    }
}

private fun CalculatorInput.getType(): Class<out CalculatorInput> {
    if (this is Number) {
        return Number::class.java
    }

    if (this is Operation) {
        return Operation::class.java
    }

    throw IllegalArgumentException("잘못된 타입")
}
