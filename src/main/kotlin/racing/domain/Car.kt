package racing.domain

class Car(
    val name: Name,
    private val moveStrategy: MoveStrategy,
) {
    var position = 0
        private set

    fun move() {
        position += moveStrategy.getMoveDistance()
    }
}
