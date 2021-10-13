package calculator

class Divide : Operation {
    companion object {
        val CANNOT_BE_DIVIDED_BY_ZERO = "0으로 나눌 수 없습니다."
    }

    override fun calculate(firstOperand: Int, secondOperand: Int): Double {
        if (secondOperand == 0) {
            throw IllegalArgumentException(CANNOT_BE_DIVIDED_BY_ZERO)
        }

        return firstOperand.toDouble() / secondOperand.toDouble()
    }
}
