package racing.domain

interface CarMoveStrategy {
    fun values(tryCount: Int): List<Int>
}
