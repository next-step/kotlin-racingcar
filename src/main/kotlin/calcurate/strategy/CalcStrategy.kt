package calcurate.strategy

interface CalcStrategy {
    val symbol: String
    fun calc(prev: Double, next: Double): Double
}
