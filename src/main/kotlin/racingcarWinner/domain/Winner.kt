package racingcarWinner.domain

class Winner(
    private var maxMoveStep: Int = DEFAULT_MAX_MOVE_STEP
) {
    fun setMaxMoveStep(moveStep: Int) {
        if (moveStep > maxMoveStep) maxMoveStep = moveStep
    }

    fun getWinner(carsList: List<Car>): List<String> =
        carsList.filter { car -> car.moveStep == maxMoveStep }.map { it.carName }

    companion object {
        private const val DEFAULT_MAX_MOVE_STEP = 0
    }
}
