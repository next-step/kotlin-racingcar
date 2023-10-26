package calculator

class Number(
    val value: Double
) {
    companion object {
        val ZERO = Number(0.0).value
    }
}
