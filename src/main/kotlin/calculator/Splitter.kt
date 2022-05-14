package calculator

class Splitter(formula: String) {
    val numbers: List<Float>

    val operations: List<String>

    init {
        val formulas = formula.split(" ")
        numbers = getNumbers(formulas)
        operations = getOperations(formulas)
    }

    private fun getNumbers(inputs: List<String>): List<Float> {
        return groupByIsNumber(inputs)[true]!!.map { it.toFloat() }
    }


    private fun getOperations(inputs: List<String>): List<String> {
        return groupByIsNumber(inputs)[false]!!
    }
    
    private fun groupByIsNumber(inputs: List<String>): Map<Boolean, List<String>> {
        return inputs.groupBy { (it.toFloatOrNull() != null) }
    }

}