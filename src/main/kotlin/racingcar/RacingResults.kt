package racingcar

class RacingResults(val value: List<RacingResult> = listOf()) {
    fun add(racingResult: RacingResult): RacingResults {
        return RacingResults(this.value + racingResult)
    }
}
