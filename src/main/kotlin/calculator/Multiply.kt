package calculator

class Multiply : Operation {
    override fun calculate(firstOperand: Int, secondOperand: Int): Double =
        firstOperand.toDouble() * secondOperand.toDouble()
}
