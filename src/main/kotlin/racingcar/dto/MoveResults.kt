package racingcar.dto

data class MoveResults(
    val data: List<MoveResult>
) {

    data class MoveResult(
        val carName: String,
        val moveDistance: Int
    )
}
