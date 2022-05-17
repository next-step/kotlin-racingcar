package racing

class Game {
    val carList: MutableList<Car> = mutableListOf()
    private val gameEngine = GameEngine

    fun run(carNumber: Int, turnNumber: Int) {
        initializeCarList(carNumber)
        ResultView().showReadyMessage()

        (0 until turnNumber).forEach { _ ->
            gameEngine.playTurnForAllCar(carList)
            ResultView().printCurrentRound(carList)
        }
    }
    fun clearCarList() {
        carList.clear()
    }

    private fun initializeCarList(carNumber: Int) {
        (0 until carNumber).forEach {
            carList.add(Car(it))
        }
    }
}
