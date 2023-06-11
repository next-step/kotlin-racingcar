package next.step.racing.domain.car

typealias DrivingStrategy = () -> Int

data class Car(val name: CarName, var pos: CarPosition) {

    fun move(drivingStrategy: DrivingStrategy): Car {
        pos = pos.move(drivingStrategy())
        return this
    }

    fun position() = pos.x

    fun isAt(pos: CarPosition): Boolean = this.pos == pos

    fun name() = name.name
}
