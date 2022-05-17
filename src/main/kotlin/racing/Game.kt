package racing

class Game {
    private val carList: MutableList<Car> = mutableListOf<Car>()
    private val gameEngine = GameEngine

    fun run(carNumber: Int, turnNumber: Int) {
        initializeCarList(carNumber)
        ResultView().showReadyMessage()

        (0 until turnNumber).forEach { _ ->
            gameEngine.playTurnForAllCar(carList)
            ResultView().printCurrentRound(carList)
        }
    }
    fun clearResult() {
        carList.clear()
    }
    private fun initializeCarList(carNumber: Int) {
        (0 until carNumber).forEach {
            carList.add(Car(it))
        }
    }

}
