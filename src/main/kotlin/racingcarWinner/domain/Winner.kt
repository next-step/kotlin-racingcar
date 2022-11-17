package racingcarWinner.domain

object Winner {
    private fun getMaxMoveStep(carsList: List<Car>): Int =
        carsList.maxOf { it.moveStep }

    fun getWinner(carsList: List<Car>): List<String> =
        carsList.filter { car -> car.moveStep == getMaxMoveStep(carsList) }.map { it.carName }
}
