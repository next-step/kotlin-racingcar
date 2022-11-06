package racingcar

data class GameResult(
    val result: List<Record>
) : List<Record> by result
