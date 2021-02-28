package racing.domain

internal interface RandomGenerator {
    fun nextInt(max: Int): Int
}
