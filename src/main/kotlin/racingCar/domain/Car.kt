package racingCar.domain

data class Car(var position: Position = Position()) {

    fun moveByStrategy(strategy: MoveStrategy) {
        if (!strategy.canMove()) {
            return
        }
        move()
    }
    fun isSamePosition(pos: Position) = this.position == pos
    private fun move() {
        this.position = position.increase()
    }

    companion object {
        fun from(pos: Int): Car = Car(Position(pos))
    }
}
