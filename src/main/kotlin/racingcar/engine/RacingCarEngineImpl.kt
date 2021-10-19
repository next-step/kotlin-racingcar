package racingcar.engine

class RacingCarEngineImpl : CarEngine {

    override fun execute(): Boolean {
        return randomNumber() >= RACING_CAR_MOVE_CRITERIA
    }

    private fun randomNumber(): Int = (0..MAX).random()

    companion object {
        const val RACING_CAR_MOVE_CRITERIA = 4
        const val MAX = 9
    }
}
