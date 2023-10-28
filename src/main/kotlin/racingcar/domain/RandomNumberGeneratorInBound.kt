package racingcar.domain

class RandomNumberGeneratorInBound: RandomNumberGenerator {
    private val randomNumberRange = (0..9)

    override fun getNumber(): Int = randomNumberRange.random()
}
