package racing.domain

interface CarMoveStrategy {
    fun carMove(tryCount: Int): List<Int>
}
