package racingcar

interface NumberGenerator {
    fun rand(): Int
}

class RacingCarNumberGenerator : NumberGenerator {
    override fun rand(): Int {
        return (0..9).random()
    }
}
