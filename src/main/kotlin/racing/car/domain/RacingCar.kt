package racing.car.domain

class RacingCar(
    position: Int = DEFAULT,
) : Car(position) {
    override fun move(input: Int) {
        if (isMovable(input)) position++
    }

    override fun isMovable(input: Int): Boolean {
        return input >= MOVABLE_NUMBER
    }
}

private const val DEFAULT = 1
private const val MOVABLE_NUMBER = 4
