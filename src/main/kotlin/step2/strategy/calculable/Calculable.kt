package step2.strategy.calculable

@FunctionalInterface
interface Calculable {
    fun calculate(x: Int, y: Int): Int
}
