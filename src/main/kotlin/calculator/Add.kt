package calculator

class Add : Operation {
    override fun calculate(firstOperand: Int, secondOperand: Int): Double =
        firstOperand.toDouble() + secondOperand.toDouble()
}
