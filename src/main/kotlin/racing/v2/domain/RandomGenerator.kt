package racing.v2.domain

interface RandomGenerator {
    fun nextInt(upperBound: Int): Int
}
