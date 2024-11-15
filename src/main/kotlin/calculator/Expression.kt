package calculator

import java.util.regex.MatchResult
import java.util.regex.Pattern

class Expression(
    private val expression: String,
) {
    init {
        validate(expression)
    }

    fun extractNumbers(): List<Double> {
        return Pattern.compile(NUMBER_REGEX)
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(String::toDouble)
            .toList()
    }

    fun extractOperators(): List<Operator> {
        return Pattern.compile(OPERATOR_REGEX)
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(Operator::from)
            .toList()
    }

    private fun validate(expression: String) {
        val pattern = Pattern.compile(EXPRESSION_REGEX)
        
        return Pattern.compile("[+\\-*/]")
            .matcher(expression)
            .results()
            .map(MatchResult::group)
            .map(::mapOperator)
            .toList()
    }

    private fun mapOperator(operator: String): Operator {
        return when (operator) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.MULTIPLY
            "/" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("올바르지 않은 연산자입니다.")
        }
    }

    private fun validate(expression: String) {
        val pattern = Pattern.compile("^\\d+( [+\\-*/] \\d+)*$")
        val matcher = pattern.matcher(expression)
        val isValid = matcher.matches()

        require(isValid) { "올바른 수식이 아닙니다." }
    }
}
