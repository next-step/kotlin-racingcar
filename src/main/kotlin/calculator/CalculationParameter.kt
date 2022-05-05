package calculator

class CalculationParameter {
    var operators: List<String> = emptyList<String>()
    var factors: List<Int> = emptyList<Int>()

    constructor(arithmeticExpression: String?) {
        if (arithmeticExpression == null) throw Error()

        operators = OPERATOR_REGEX.findAll(arithmeticExpression).map {
            it.groupValues[0]
        }.toList()

        factors = OPERATOR_REGEX.split(arithmeticExpression).map {
            Integer.parseInt(it.replace(Regex("\\s"), ""))
        }
    }

    companion object {
        private val OPERATOR_REGEX = Regex("([+-/*])")
    }
}
