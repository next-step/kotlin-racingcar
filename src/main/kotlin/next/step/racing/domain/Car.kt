package next.step.racing.domain

data class Car(val pos: Position) {
    fun move(drivingStrategy: () -> Int): Car = Car(pos.move(drivingStrategy()))
    fun position() = pos.x
}
