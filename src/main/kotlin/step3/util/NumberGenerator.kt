package step3.util

fun interface NumberGenerator {
    fun generate(minValue: Int, maxValue: Int): Int
}