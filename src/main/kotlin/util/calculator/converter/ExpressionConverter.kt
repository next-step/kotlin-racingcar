package util.calculator.converter

import domain.caculator.Operator

class ExpressionConverter private constructor() {

    companion object {
        private const val CHUNK_SIZE = 2

        fun convert(expressionInput: String) = "+ $expressionInput".split(" ")
            .chunked(CHUNK_SIZE)
            .map { Operator.of(it.first()) to it.last().toInt() }
    }
}
