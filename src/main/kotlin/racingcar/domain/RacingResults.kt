package racingcar.domain

class RacingResults(trials: List<RacingTrial>) {
    val trials: List<RacingTrial> = trials.sortedBy { it.order }

    init {
        this.trials.forEachIndexed { index, trial -> trial.checkOrder(index) }
    }

    val winnerRecords: List<Record>
        get() = lastTrial.leadRecords

    private val lastTrial: RacingTrial
        get() = trials.last()
}
