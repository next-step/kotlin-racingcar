package domain.step2.strategy.calculate

@FunctionalInterface
fun interface CalculateStrategy {
    fun calculate(x: Int, y: Int): Int
}
