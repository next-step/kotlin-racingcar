package racingcar.turn

class SimpleTurnManager(override val totalSteps: Int, override val turn: Turn) : TurnManager {

    var lastResult = turn
    override fun isFinishOrProceed(): Turn? {
        if (isFinish()) {
            return null
        }
        lastResult = lastResult.nextTurn()
        return lastResult
    }

    fun isFinish() = lastResult.current >= totalSteps
}
