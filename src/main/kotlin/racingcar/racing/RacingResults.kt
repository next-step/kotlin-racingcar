package racingcar.racing

class RacingResults(val trials: List<RacingTrial>) {
    init {
        trials.forEachIndexed { index, trial -> trial.checkOrder(index) }
    }

    val winnerRecords: List<Record>
        get() = lastTrial.leadRecords

    private val lastTrial: RacingTrial
        get() = trials.last()
}
