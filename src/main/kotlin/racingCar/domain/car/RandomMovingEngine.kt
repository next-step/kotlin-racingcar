package racingCar.domain.car

class RandomMovingEngine(
    private val minRandomValue: Int = 0,
    private val maxRandomValue: Int = 9,
    private val moveThreshold: Int = 4,
    private val defaultMoveDistance: Int = 1
) : Engine {

    private val availableRange: IntRange = (minRandomValue..maxRandomValue)

    override fun getMoveDistance(): Int {
        if (availableRange.random() >= moveThreshold) {
            return defaultMoveDistance
        }
        return 0
    }
}
