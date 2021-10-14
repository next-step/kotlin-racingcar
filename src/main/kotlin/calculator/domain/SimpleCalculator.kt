package calculator.domain

import calculator.common.SPACE
import calculator.domain.vo.Operator.Companion.isOperator
import calculator.domain.vo.Expression
import calculator.domain.vo.Operator
import calculator.domain.vo.Term

object SimpleCalculator : Calculator {
    override fun calculate(input: String): Term {
        val (_operators, _terms) = input
            .split(SPACE)
            .partition { it.isOperator() }
        val operators = _operators.toOperators()
        val terms = _terms.toTerms()
        val answer = terms.reduceIndexed { index, accumulative, term ->
            Expression(
                left = accumulative,
                operator = operators[index - 1],
                right = term,
            ).calculate()
        }
        return answer
    }

    private fun List<String>.toOperators() = this.map { Operator.symbolOf(it) }
    private fun List<String>.toTerms() = this.map { Term(it) }
}
