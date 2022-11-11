package racingcar

private const val FORWARD_THRESHOLD = 4

class StandardCar(
    position: Position = Position.ZERO
) : Car {
    override var position: Position = position
        private set

    override fun move(power: Int) {
        if (power >= FORWARD_THRESHOLD) {
            position++
        }
    }
}
