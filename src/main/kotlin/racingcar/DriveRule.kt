package racingcar

class DriveRule : DriveRangeStrategy {
    companion object {
        private const val NUMBER_RANDOM_MAX = 9
        const val FORWARD_NUMBER = 4
    }

    fun random(): Int {
        return (0..NUMBER_RANDOM_MAX).random()
    }

    override fun isForward(): Boolean {
        return random() >= FORWARD_NUMBER
    }
}
