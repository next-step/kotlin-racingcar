package calculator

class Calculator(private val formulas: List<String>) {

    init {
        if (formulas.isEmpty() || formulas[0] == "") {
            throw IllegalArgumentException("수식을 입력해 주세요.")
        }

        if (!Number.isNumber(formulas[formulas.size-1])) {
            throw IllegalArgumentException("수식의 마지막은 숫자여야 합니다.")
        }

        formulas.forEachIndexed { index, formula ->
            validateIsNumber(index, formula)
            validateIsArithmetic(index, formula)
        }
    }

    private fun validateIsNumber(index: Int, formula: String) {
        if (index % 2 != 1 && !Number.isNumber(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    private fun validateIsArithmetic(index: Int, formula: String) {
        if (index % 2 != 0 && !Arithmetic.isArithmetic(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    fun calculate(): Number {
        var result = Expression(Number(0))
        for (element in formulas) {
            result = result.put(element)
        }
        return result.number
    }

    constructor(formula: String) : this(formula.split(" "))
}
