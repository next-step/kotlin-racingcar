package racingcar

class ResultView {
    fun print(results: RacingResults) {
        println("실행 결과")
        results.trials.forEach(this::printTrial)
    }

    private fun printTrial(trial: RacingTrial) {
        trial.locations.forEach(this::printCarLocation)
        println()
    }

    private fun printCarLocation(location: CarLocation) {
        println("-".repeat(START_LINE + location.value.toInt()))
    }

    companion object {
        const val START_LINE = 1
    }
}
