package racing

class Game {
    lateinit var carList: List<Car>
    private val gameEngine = GameEngine

    fun run(car: Int, turn: Int) {
        initializeCarList(car)
        val resultView = ResultView()
        resultView.showReadyMessage()

        repeat(turn){
            gameEngine.playTurnForAllCar(carList)
            resultView.printCurrentRound(carList)
        }
    }
    fun clearCarList() {
        carList = listOf()
    }

    private fun initializeCarList(carNumber: Int) {
        this.carList = (0 until carNumber)
            .map{ Car(it) }
    }
}
