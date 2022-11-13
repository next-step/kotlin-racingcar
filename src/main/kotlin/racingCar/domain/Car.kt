package racingCar.domain

data class Car(var position: Position = Position()) {
    private fun move() {
        this.position = position.increase()
    }

    fun moveByStrategy(strategy: MoveStrategy) {
        if (!strategy.canMove()) {
            return
        }
        move()
    }

    fun isSamePosition(pos: Position) = this.position == pos

    companion object {
        fun from(pos: Int): Car = Car(Position(pos))
    }
}
