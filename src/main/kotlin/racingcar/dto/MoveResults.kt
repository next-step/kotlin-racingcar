package racingcar.dto

class MoveResults(
    val result: List<MoveResult>
) {
    val farthestDistanceCarNames: List<String>
        get() {
            val farthestDistance = result.maxOf { it.moveDistance }
            return result
                .filter { it.moveDistance == farthestDistance }
                .map { it.carName }
        }

    data class MoveResult(
        val carName: String,
        val moveDistance: Int
    )
}
