package racingcar

data class GameResult(
    private val result: List<Record>
) : List<Record> by result {
    fun getLastRoundRecord(): Record {
        return result.last()
    }
}
