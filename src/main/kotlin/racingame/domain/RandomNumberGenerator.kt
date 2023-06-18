package racingame.domain

class RandomNumberGenerator : NumberGenerator {
    private val randomNumber: Int
        get() = (1..MAX).random()

    override fun generate(): Int {
        return randomNumber
    }

    companion object {
        private const val MAX = 9
    }
}
