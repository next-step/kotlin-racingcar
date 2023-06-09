package next.step.racing.domain

data class Car(val pos: Position) {
    fun move(drivingStrategy: () -> Int): Car = Car(pos.move(drivingStrategy()))
    fun position() = pos.x

    companion object {
        fun init(): Car {
            return Car(Position(0))
        }

        fun at(pos: Int): Car {
            return Car(Position(pos))
        }
    }
}
