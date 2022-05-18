package racingcar.domain

class RacingLap(
    private val goalLap: Int
) {
    init {
        require(MIN_RACING_LAP <= goalLap) { "레이싱 시도 횟수는 최소 $MIN_RACING_LAP 이상이어야 합니다." }
    }

    private var currentLap: Int = 0

    fun waveTheFlag() {
        currentLap += 1
    }

    fun isNotFinished(): Boolean {
        return goalLap != currentLap
    }

    companion object {
        const val MIN_RACING_LAP = 1
    }
}
