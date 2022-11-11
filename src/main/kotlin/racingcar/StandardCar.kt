package racingcar

private const val FORWARD_THRESHOLD = 4

class StandardCar(override var position: Position = Position.ZERO) : Car {
    override fun move(power: Int) {
        if (power >= FORWARD_THRESHOLD) {
            position++
        }
    }
}
