package racingcar.domain

class RacingCarGame(
    private val cars: Cars,
    private val attemptCount: Int,
    private val onEachRace: (Cars) -> Unit
) {

    fun play(): Cars {
        return cars
    }
}