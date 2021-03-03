package racingcar.domain

class RandomMoveStrategy(private val randomGenerator: RandomGenerator, private val threshold: Int) : MoveStrategy {

    override fun isMoveable(): Boolean {
        val randomValue = randomGenerator.makeRandomValue()
        return threshold >= randomValue
    }
}
