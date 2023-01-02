package util.calculator.converter

import domain.caculator.Operator

object ExpressionConverter {

    private const val CHUNK_SIZE = 2

    fun convert(expressionInput: String) = "+ $expressionInput".split(" ")
        .chunked(CHUNK_SIZE)
        .map { Operator.of(it.first()) to it.last().toInt() }
}
