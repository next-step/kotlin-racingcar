package racing

class Game {
    private val carList: MutableList<Car> = mutableListOf<Car>()
    private val gameEngine = GameEngine

    fun run(carNumber: Int, turnNumber: Int) {

        initializeCarList(carNumber)

        (0 until turnNumber).forEach { _ ->
            gameEngine.playTurnForAllCar(carList)
            printCurrentRound(carList)
        }
    }
    fun clearResult() {
        carList.clear()
    }
    private fun initializeCarList(carNumber: Int) {

        (0 until carNumber).forEach {
            carList.add(Car(it))
        }
        println("실행 결과")
    }
    private fun printCurrentRound(carList: List<Car>) {

        carList.forEach {
            val pathString = "-".repeat(it.currentLocation)
            println("${it.number}: $pathString")
        }
        println()
    }
}
