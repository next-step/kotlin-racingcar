package racingcar.domain.carracer

private val RANDOM_BOUND = 0..9
const val MOVING_BENCHMARK = 4

class RandomCarRacer : CarRacer {
    override fun canMove() = RANDOM_BOUND.random() >= MOVING_BENCHMARK
}
