package calculator.dto

import calculator.study.Operand
import calculator.study.StringOperator

class AbstractSyntaxTree(numbers: List<String>, operators: List<String>) {
    val numbers = numbers.map(Operand::of)
    val operators = operators.map(StringOperator::of)

    init {
        require((operators.size + 1) == numbers.size)
    }
}
