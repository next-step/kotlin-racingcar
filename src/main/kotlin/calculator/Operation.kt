package calculator

object Operation {

    fun of(operator: String) = operators[operator]

    val none: (Double, Double) -> Double = { _, _ -> Double.NaN }

    private val add: (Double, Double) -> Double = { base, second -> base + second }

    private val sub: (Double, Double) -> Double = { base, second -> base - second }

    private val multi: (Double, Double) -> Double = { base, second -> base * second }

    private val div: (Double, Double) -> Double = { base, second ->
        when (second) {
            0.0 -> Double.NaN
            else -> base / second
        }
    }

    private val operators = hashMapOf(Pair("+", add), Pair("-", sub), Pair("*", multi), Pair("/", div))
}
