package racingcar.domain

class RacingLap(
    private val goalLap: Int
) {
    private var currentLap: Int = 0

    fun waveTheFlag() {
        currentLap += 1
    }

    fun isFinished(): Boolean {
        return goalLap == currentLap
    }
}
