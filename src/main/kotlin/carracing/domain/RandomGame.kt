package carracing.domain

import kotlin.random.Random

class RandomGame : RacingGameRule {
    override fun execute(cars: List<Car>) {
        cars.map {
            if (isMove()) it.move()
        }
    }

    private fun isMove(): Boolean {
        val num = Random.nextInt(RANDOM_RANGE)
        return num >= MOVE_VALUE
    }

    companion object {
        private const val RANDOM_RANGE = 10
        private const val MOVE_VALUE = 4
    }
}
