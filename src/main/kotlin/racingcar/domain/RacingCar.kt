package racingcar.domain

class RacingCar(
    val progress: Int = 1
) {
    fun carProgress(randomNumber: () -> Int): RacingCar {
        if (checkCanGo { randomNumber() }) {
            return RacingCar(1 + progress)
        }
        return RacingCar(progress)
    }

    private fun checkCanGo(randomNumber: () -> Int): Boolean {
        return randomNumber() >= RESTRICT_NUMBER
    }

    companion object {
        private const val RESTRICT_NUMBER = 4
    }
}
