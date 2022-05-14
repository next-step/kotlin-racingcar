package calculator

class Splitter(formula: String) {
    val numbers: List<Float>

    val operations: List<String>

    init {
        val formulas = formula.split(" ")
        numbers = groupByIsNumber(formulas, true).map { it.toFloat() }
        operations = groupByIsNumber(formulas, false)

        // TODO 올바른 입력 값이 아닙니다.
    }

    private fun groupByIsNumber(inputs: List<String>, bool: Boolean): List<String> {
        return inputs.groupBy { (it.toFloatOrNull() != null) }[bool]!!
    }
}