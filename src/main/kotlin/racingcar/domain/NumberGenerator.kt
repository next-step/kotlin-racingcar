package racingcar.domain

fun interface NumberGenerator {
    fun generate(from: Int, until: Int): Int
}
