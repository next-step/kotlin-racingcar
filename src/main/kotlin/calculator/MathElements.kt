package calculator

class MathElements(private val elements: List<MathElement>) {

    fun calculate(): Float {
        var result = Operand(0f)
        var currentOperator: Operator? = null

        elements.forEach { element ->
            when (element) {
                is Operator -> currentOperator = element
                is Operand -> {
                    result = currentOperator?.calculate(result, element) ?: element
                }
            }
        }

        return result.value
    }

    fun isValid(): Boolean {
        return elements.isNotEmpty() && isOperandAtFirst() && isOperandAtLast() && isValidOrder()
    }

    private fun isOperandAtFirst(): Boolean {
        return elements.firstOrNull()
            ?.isOperand() == true
    }

    private fun isOperandAtLast(): Boolean {
        return elements.lastOrNull()
            ?.isOperand() == true
    }

    private fun isValidOrder(): Boolean {
        elements.reduce { previous, current ->
            if (isValidOrder(previous, current).not()) return false
            current
        }
        return true
    }

    private fun isValidOrder(prevElement: MathElement, currentElement: MathElement): Boolean {
        return when (currentElement) {
            is Operator -> prevElement.isOperand()
            is Operand -> prevElement.isOperator()
        }
    }
}
