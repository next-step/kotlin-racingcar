package step3.domain.car

class RandomMovingEngine(
    private val minRandomValue: Int = 0,
    private val maxRandomValue: Int = 9,
    private val moveThreshold: Int = 4,
    private val defaultMoveDistance: Int = 1
) :

    Engine {
    override fun getMoveDistance(): Int {
        if ((minRandomValue..maxRandomValue).random() >= moveThreshold) {
            return defaultMoveDistance
        }
        return 0
    }
}
