package racingCar.domain

private const val MOVE_MINIMUM_POWER = 4

class Car(
    position: CarPosition = CarPosition(1)
) {

    var position: CarPosition = position
        private set

    fun move(power: Int) {
        if (power >= MOVE_MINIMUM_POWER) {
            position = position.add()
        }
    }
}
