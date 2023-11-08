package racing.v2.domain

interface NumberGenerator {
    fun generate(upperBound: Int): Int
}
