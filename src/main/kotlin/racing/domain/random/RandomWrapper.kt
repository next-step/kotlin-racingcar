package racing.domain.random

interface RandomWrapper {
    fun nextInt(until: Int): Int
}
