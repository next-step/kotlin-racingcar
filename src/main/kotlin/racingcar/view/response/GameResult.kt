package racingcar.view.response

class GameResult(
    val repsResults: MutableList<RepsResult> = mutableListOf()
) {
    fun addReps(repsResult: RepsResult) {
        repsResults.add(repsResult)
    }
}

class RepsResult(
    val snapShots: List<CarSnapShot>
)

class CarSnapShot(
    val id: Int,
    val position: Int
)
