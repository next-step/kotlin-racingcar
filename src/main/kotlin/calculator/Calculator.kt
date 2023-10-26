package calculator

class Calculator(private val formulas: List<String>) {

    init {
        if (formulas.isEmpty()) {
            throw IllegalArgumentException("수식을 입력해 주세요.")
        }

        for (index in formulas.indices) {
            validateIsNumber(index, formulas[index])
            validateIsArithmetic(index, formulas[index])
        }
    }

    private fun validateIsNumber(index: Int, formula: String) {
        if (index % 2 == 1 && !Number.isNumber(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    private fun validateIsArithmetic(index: Int, formula: String) {
        if (index % 2 == 0 && !Arithmetic.isArithmetic(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    fun calculate(): Number {
        var result = Expression(Number(0))
        for (i: Int in 0..formulas.size) {
            result = result.put(formulas[i])
        }
        return result.number
    }

    constructor(formula: String) : this(formula.split(" "))
}
