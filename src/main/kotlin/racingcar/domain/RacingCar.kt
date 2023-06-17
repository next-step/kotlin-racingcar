package racingcar.domain

class RacingCar(
    val progress: Int = 1
) {
    fun carProgress(randomNumber: () -> Int): RacingCar {
        if (checkCanGo { randomNumber() }) {
            return RacingCar(progress.progressNext())
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

private fun Int.progressNext() = this + 1
