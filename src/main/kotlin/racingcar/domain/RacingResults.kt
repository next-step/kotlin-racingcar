package racingcar.domain

class RacingResults(val value: List<RacingResult> = listOf()) {
    fun add(racingResult: RacingResult): RacingResults {
        return RacingResults(this.value + racingResult)
    }

    fun winners(): List<Car> {
        return this.value.last().winners()
    }
}
