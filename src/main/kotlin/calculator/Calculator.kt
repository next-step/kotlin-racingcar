package calculator

class Calculator(val formula: List<String>) {

    init {
        for (index in formula.indices) {
            validateIsNumber(index, formula[index])
            validateIsArithmetic(index, formula[index])
        }
    }

    private fun validateIsNumber(index: Int, formula: String) {
        if (index % 2 == 0 && !Number.isNumber(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    private fun validateIsArithmetic(index: Int, formula: String) {
        if (index % 2 == 1 && !Arithmetic.isArithmetic(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    fun calculate(): Number {
        var result = Number(0)
        for (i: Int in 0..formula.size step (2)) {
            if (i == 0) {
                result = result.sum(Number(formula[i]))
                continue
            }
            val arithmetic = Arithmetic.of(formula[i - 1])
            result = arithmetic.operation(result, Number(formula[i]))
        }
        return result
    }

    constructor(formula: String) : this(formula.split(" "))
}
