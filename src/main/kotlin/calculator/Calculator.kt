package calculator

class Calculator(private val formulas: List<String>) {

    init {
        require (formulas.isEmpty() || formulas[0] == "") {
            throw IllegalArgumentException("수식을 입력해 주세요.")
        }

        require (!Number.isNumber(formulas[formulas.size-1])) {
            throw IllegalArgumentException("수식의 마지막은 숫자여야 합니다.")
        }

        for (index in formulas.indices) {
            validateIsNumber(index, formulas[index])
            validateIsArithmetic(index, formulas[index])
        }
    }

    private fun validateIsNumber(index: Int, formula: String) {
        require (index % 2 != 1 && !Number.isNumber(formula)) {
            throw IllegalArgumentException("수식을 확인해 주세요.")
        }
    }

    private fun validateIsArithmetic(index: Int, formula: String) {
        require (index % 2 != 0 && !Arithmetic.isArithmetic(formula)) {
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
