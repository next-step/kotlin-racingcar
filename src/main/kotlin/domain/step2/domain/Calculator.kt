package domain.step2.domain

import domain.step2.domain.expression.Expression
import domain.step2.domain.expression.Operand
import domain.step2.domain.expression.Operator
import global.strategy.split.SplitStrategy

object Calculator {

    private const val SUB_LIST_START_INDEX = 1
    private const val CHUNKED_SIZE = 2
    private const val OPERATOR_INDEX = 0
    private const val OPERAND_INDEX = 0
    private const val FOLD_START_INDEX = 0

    fun calculate(expression: Expression, splitStrategy: SplitStrategy): Operand {
        val expressionWords = expression.split(splitStrategy)
        return expressionWords.subList(SUB_LIST_START_INDEX, expressionWords.size).asSequence()
            .chunked(CHUNKED_SIZE)
            .map { Pair(Operator.values(it[OPERATOR_INDEX]), Operand(it[OPERAND_INDEX])) }
            .fold(Operand(expressionWords[FOLD_START_INDEX])) { sum, monomial -> monomial.first.calculate(sum, monomial.second) }
    }
}
