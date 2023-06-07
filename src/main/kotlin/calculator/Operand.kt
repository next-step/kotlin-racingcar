package calculator

class Operand(val value: Float) : MathElement {
    companion object {
        fun from(numberString: String) = runCatching {
            Operand(numberString.toFloat())
        }.getOrElse {
            throw IllegalArgumentException()
        }
    }
}
