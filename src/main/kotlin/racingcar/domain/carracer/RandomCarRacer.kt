package racingcar.domain.carracer

private val RANDOM_BOUND = 0..9

class RandomCarRacer : CarRacer {

    override fun drive(): Int = RANDOM_BOUND.random()
}
