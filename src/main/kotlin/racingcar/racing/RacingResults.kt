package racingcar.racing

class RacingResults(val trials: List<RacingTrial>) {
    init {
        trials.forEachIndexed { index, trial ->
            require(trial.order == TrialOrder(index + 1)) {
                "The results of racing is not ordered. trial orders=${trials.map { it.order }}"
            }
        }
    }

    val winnerRecords: List<Record>
        get() = lastTrial.leadRecords

    private val lastTrial: RacingTrial
        get() = trials.last()
}
