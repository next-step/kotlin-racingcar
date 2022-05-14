package racingcar.car

data class MoveResults(
    val result: List<MoveResult>
) {
    data class MoveResult(
        val carName: String,
        val moveDistance: Int
    )
}
