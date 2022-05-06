package step2

interface Operation {
    fun calc(n2: Int): Int

    companion object {
        fun get(operand: String): (Int) -> Operation = when (operand) {
            "+" -> { n1: Int -> AdditionWithN1(n1) }
            "-" -> { n1: Int -> SubtractionWithN1(n1) }
            "*" -> { n1: Int -> MultiplicationWithN1(n1) }
            "/" -> { n1: Int -> DivisionWithN1(n1) }
            else -> throw IllegalArgumentException("Invalid operand: $operand")
        }
    }
}

class AdditionWithN1(val n1: Int) : Operation {
    override fun calc(n2: Int): Int = n1 + n2
}

class SubtractionWithN1(val n1: Int) : Operation {
    override fun calc(n2: Int): Int = n1 - n2
}

class MultiplicationWithN1(val n1: Int) : Operation {
    override fun calc(n2: Int): Int = n1 * n2
}

class DivisionWithN1(val n1: Int) : Operation {
    override fun calc(n2: Int): Int = n1 / n2
}
