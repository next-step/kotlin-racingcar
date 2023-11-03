package racingCar.domain

private const val INIT_POSITION = 1
private const val MOVE_MINIMUM_POWER = 4

class Car(
    val name: CarName,
    position: CarPosition = CarPosition(INIT_POSITION)
) {

    var position: CarPosition = position
        private set

    fun move(power: Int) {
        if (power >= MOVE_MINIMUM_POWER) {
            position = position.add()
        }
    }
}
