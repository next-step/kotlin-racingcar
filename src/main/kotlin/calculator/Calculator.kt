package calculator

object Calculator {
    fun calculate(elements: List<String>): Int {
        ValidationFormula.validateFormula(elements)
        var result = elements[0].toInt()

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toInt()

            result = Operator.from(operator).calculate(result, operand)
        }

        return result
    }
}
