package step2.calculable

@FunctionalInterface
interface Calculable {
    fun calculate(x: Int, y: Int): Int
}
