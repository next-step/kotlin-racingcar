package racingcar

class RacingResults(val values: List<RacingResult> = listOf()) {
    fun add(value: RacingResult): RacingResults {
        val valuesTemp = values.toMutableList()
        valuesTemp.add(value)
        return RacingResults(valuesTemp.toList())
    }
}
