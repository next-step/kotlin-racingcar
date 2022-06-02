package racingcar.view.response

class GameResult(
    val repsResults: MutableList<RepsResult> = mutableListOf(),
    val winners: MutableList<Winner> = mutableListOf()
) {
    fun addReps(repsResult: RepsResult) {
        repsResults.add(repsResult)
    }

    fun addWinners(winnerNames: List<String>) {
        this.winners.addAll(winnerNames.map { Winner(it) })
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
