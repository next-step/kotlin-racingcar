package calculator

class Subtract : Operation {
    override fun calculate(firstOperand: Int, secondOperand: Int): Double =
        firstOperand.toDouble() - secondOperand.toDouble()
}
