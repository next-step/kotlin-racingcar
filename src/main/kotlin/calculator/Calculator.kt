package calculator

interface Calculator {
    fun calculate(): Double
}

class StringCalculator(
    private val expression: String
) : Calculator {

    override fun calculate(): Double {
        return 0.0
    }
}

