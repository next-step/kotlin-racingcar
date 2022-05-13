package calculator.dto

import calculator.study.Operand
import calculator.study.StringOperator

class AST(numbers: List<String>, operators: List<String>) {
    val numbers = numbers.map(Operand::of)
    val operators = operators.map(StringOperator::of)
}
