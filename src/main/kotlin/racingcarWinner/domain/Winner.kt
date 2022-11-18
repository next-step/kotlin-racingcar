package racingcarWinner.domain

object Winner {
    fun getWinner(cars: Cars): List<String> =
        cars.findMaxMoveStepCarNameList()
}
