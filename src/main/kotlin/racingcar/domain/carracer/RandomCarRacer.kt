package racingcar.domain.carracer

private val RANDOM_BOUND = 0..9

class RandomCarRacer : CarRacer {

    override fun race(): Int = RANDOM_BOUND.random()
}
