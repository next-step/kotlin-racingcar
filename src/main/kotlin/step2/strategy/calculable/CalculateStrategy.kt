package step2.strategy.calculable

@FunctionalInterface
fun interface CalculateStrategy {
    fun calculate(x: Int, y: Int): Int
}
