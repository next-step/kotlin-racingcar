package stringcalculator.operator

object OperatorRegister {
    val operators = listOf(
        PlusOperator(),
        MinusOperator(),
        MultiplyOperator(),
        DivideOperator()
    )
}
