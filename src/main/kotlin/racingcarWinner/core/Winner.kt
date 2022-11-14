package racingcarWinner.core

object Winner {

    fun getWinner(carsList: List<Car>, maxMoveStep: Int): List<String> =
        carsList.filter { car -> car.moveStep == maxMoveStep }.map { it.carName }
}
