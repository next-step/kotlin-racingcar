package racingcar

class RacingResults(val value: List<RacingResult> = listOf()) {
    fun add(value: RacingResult): RacingResults {
        val valueTemp = this.value.toMutableList()
        valueTemp.add(value)
        return RacingResults(valueTemp.toList())
    }
}
