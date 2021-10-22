package racingcar.domain

class RandomMovingStrategy : MovingStrategy {

    companion object {
        private const val MINIMUM_MOVE = 4
    }

    override fun ableMove(): Boolean {
        val random = (0..9).random()
        return random > MINIMUM_MOVE
    }
}
