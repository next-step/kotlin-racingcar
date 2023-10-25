package calculator

class Calculator(val formula: List<String>) {

    init {
        for (index in formula.indices) {
            validateIsNumber(index, formula[index])
            validateIsArithmetic(index, formula[index])
        }
    }

    private fun validateIsNumber(index: Int, formula: String) {
        if (index % 2 != 0) {
            return
        }
        formula.toIntOrNull() ?: throw IllegalArgumentException()
    }

    private fun validateIsArithmetic(index: Int, formula: String) {
        if (index % 2 != 1) {
            return
        }
        try {
            Arithmetic.of(formula)
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException()
        }
    }

    fun calculate(): Int {
        var result = 0
        for (i: Int in 0..formula.size step (2)) {
            if (i == 0) {
                result += formula[i].toInt()
                continue
            }
            val arithmetic = Arithmetic.of(formula[i - 1])
            result = arithmetic.operation(result, formula[i].toInt())
        }
        return result
    }

    constructor(formula: String) : this(formula.split(" "))
}
