package racingcar

data class Car(
    var location: Int = 0,
    private val engine: Engine = RandomPowerEngine(),
    private val wheel: Wheel = Wheel()
) {
    fun move() {
        val power = engine.powerUp()
        location += wheel.nextLocation(power)
    }

    override fun toString(): String {
        return "-".repeat(location)
    }
}
