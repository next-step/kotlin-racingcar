package racingcar.view.response

class GameResult(
    private val _repsResults: MutableList<RepsResult> = mutableListOf(),
    private val _winners: MutableList<Winner> = mutableListOf(),
) {
    val repsResults: List<RepsResult>
        get() = _repsResults
    val winners: List<Winner>
        get() = _winners

    fun addReps(repsResult: RepsResult) {
        _repsResults.add(repsResult)
    }

    fun addWinners(winnerNames: List<String>) {
        this._winners.addAll(winnerNames.map { Winner(it) })
    }
}

class RepsResult(
    val snapShots: List<CarSnapShot>
)

class CarSnapShot(
    val name: String,
    val position: Int
)

class Winner(
    val name: String
)
