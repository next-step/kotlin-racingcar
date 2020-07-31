package racingcar.turn

interface TurnManager {
    val totalSteps: Int

    val turn: Turn
    fun isFinishOrProceed(): Turn?
}
