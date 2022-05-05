package calculator

import java.lang.Integer.parseInt

val OPERATOR_REGEX = Regex("([+-/*])")

class Calculator {
    constructor(arithmeticExpression: String?) {
        if (arithmeticExpression == null) throw Error()

        val operators = OPERATOR_REGEX.find(arithmeticExpression)?.groupValues

        val factors: List<Int> = OPERATOR_REGEX.split(arithmeticExpression).map {
            parseInt(it.replace(Regex("\\s"), ""))
        }
    }
}
