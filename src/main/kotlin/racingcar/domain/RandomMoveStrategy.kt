package racingcar.domain

class RandomMoveStrategy(private val threshold: Int) : MoveStrategy {

    override fun isMoveable(): Boolean {
        val random = java.util.Random()
        val randomValue = random.nextInt(10)
        return threshold >= randomValue
    }
}
