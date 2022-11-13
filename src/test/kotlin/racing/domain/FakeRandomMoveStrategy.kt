package racing.domain

class FakeRandomMoveStrategy(
    private val move: Boolean
) : MoveStrategy {
    override fun move(): Boolean = move
}
