package racingcar.domain

class RandomNumberGenerator {

    fun generate() = Number(numberRange.random())

    companion object {
        private val numberRange = (Number.MINIMUM_VALUE..Number.MAXIMUM_VALUE)
    }
}
