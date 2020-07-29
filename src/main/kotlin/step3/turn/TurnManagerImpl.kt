package step3.turn

class TurnManagerImpl(override val totalSteps: Int, override val turn: Turn) : TurnManager {

    override fun isFinishOrProceed(): Boolean {
        if (isFinish()) {
            return true
        }
        turn.nextTurn()
        return false
    }

    fun isFinish() = turn.current >= totalSteps
}
