package calculator

class Formula(formula: String) {
    val numbers: List<Float>

    val operations: List<String>

    init {
        val formulas = formula.split(" ")
        val numbersAndOperations = groupByIsNumber(formulas)
        numbers = numbersAndOperations[true]!!.map { it.toFloat() }
        operations = numbersAndOperations[false]!!
    }

    private fun groupByIsNumber(inputs: List<String>): Map<Boolean, List<String>> {
        return inputs.groupBy { (it.toFloatOrNull() != null) }
    }
}
