package racing.util

fun interface NumberGenerator {
    fun generate(minValue: Int, maxValue: Int): Int
}
