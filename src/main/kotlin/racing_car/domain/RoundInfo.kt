package racing_car.domain

data class RoundInfo(
    val totalRound: Int,
    private var currentRound: Int = 0
) {

    init {
        require(totalRound >= 1) { "경주는 1번 이상 시도되어야합니다." }
    }

    val isContinuable: Boolean
        get() = currentRound < totalRound

    val isFinish: Boolean
        get() = !isContinuable

    fun increaseCurrentRound() {
        currentRound++
    }
}
