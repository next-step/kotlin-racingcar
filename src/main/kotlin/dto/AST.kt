package dto

import study.Operand
import study.StringOperator

class AST(numbers: List<String>, operators: List<String>) {
    val numbers = numbers.map(Operand::of)
    val operators = operators.map(StringOperator::of)
}
