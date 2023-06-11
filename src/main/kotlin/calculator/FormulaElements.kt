package calculator

import calculator.Operand.Companion.toOperand

class FormulaElements(private val formulas: List<String>) {
    val startValue: Operand by lazy {
        formulas.first().toDouble().toOperand()
    }
    private val elementQueue: MutableList<FormulaElement> by lazy {
        formulas.drop(1).chunked(2).map { FormulaElement(it[1].toDouble().toOperand(), Operation.of(it[0])!!) }.let { ArrayDeque(it) }
    }

    init {
        checkValidateFormulaOrThrows()
        startValue
        elementQueue
    }

    fun nextFormulaElement(): FormulaElement? = elementQueue.removeFirstOrNull()

    private fun checkValidateFormulaOrThrows() {
        shouldContainNumber()
        numbersShouldValidPositions()
        operationsShouldValidPositions()
        shouldOddNumberDivided()
    }

    private fun shouldContainNumber() = require(formulas.any { it.toDoubleOrNull() != null })

    private fun numbersShouldValidPositions() = formulas.filterIndexed { index, _ -> index.isEven() }
        .forEach { require(it.toDoubleOrNull() != null) }

    private fun operationsShouldValidPositions() = formulas.filterIndexed { index, _ -> !index.isEven() }
        .forEach { require(Operation.of(it) != null) }

    private fun shouldOddNumberDivided() = require((formulas.size % 2) == 1)

    private fun Int.isEven() = (this % 2) == 0
}

data class FormulaElement(
    val operand: Operand,
    val operator: Operation
) {
    init {
        shouldNotDividedByZero()
    }

    private fun shouldNotDividedByZero() = require(this != dividedByZero)

    companion object {
        private val dividedByZero = FormulaElement(operand = 0.0.toOperand(), Operation.DIVIDER)
    }
}

interface Operand {
    val value: Double

    private abstract class Base() : Operand {
        override fun equals(other: Any?): Boolean {
            if (other !is Operand) return false
            return value == other.value
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }

    private class RealNumber(override val value: Double) : Base()

    companion object {
        fun Double.toOperand(): Operand = RealNumber(this)
    }
}
