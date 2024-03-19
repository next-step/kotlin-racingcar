package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private val totalRound: Int
) {
    private var currentRound = 0

    init {
        when {
            totalRound < 1 -> {
                throw IllegalArgumentException("라운드는 $MIN_ROUND 이상이어야 합니다.")
            }
        }
    }

    fun play() {
        if (currentRound < totalRound) {
            cars.move()
            currentRound += 1
        }
    }

    fun isFinished(): Boolean {
        return currentRound == totalRound
    }

    fun getCars(): List<CarDto> = cars.getCars()

    companion object {
        const val MIN_ROUND = 1
    }
}