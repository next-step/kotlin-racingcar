package study.racingcar.generator

class RandomNumberGenerator : Generator {
    override fun generate(): Int {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).random()
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val MAXIMUM_NUMBER = 9
    }
}
