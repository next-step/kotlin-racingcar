package racingcar.domain

private val RANDOM_NUMBER_RANGE = 0..9

class RandomNumberStrategy: Strategy {
    override fun moveStrategy(): Int {
        return (RANDOM_NUMBER_RANGE).random()
    }
}