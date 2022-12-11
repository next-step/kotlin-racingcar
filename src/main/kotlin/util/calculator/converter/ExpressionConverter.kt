package util.calculator.converter

import domain.caculator.Operator

class ExpressionConverter private constructor() {

    companion object {
        fun convert(expressionInput: String) = "+ $expressionInput".split(" ")
            .chunked(2)
            .map { Operator.of(it.first()) to it.last().toInt() }
    }
}
