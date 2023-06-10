package next.step.racing.domain

import next.step.racing.util.DrivingStrategy

data class Car(val pos: Position) {
    fun move(drivingStrategy: DrivingStrategy): Car = Car(pos.move(drivingStrategy()))
    fun position() = pos.x
}
