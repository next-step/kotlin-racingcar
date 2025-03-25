package carracing

fun main() {
    val inputView = InputView()
    val outputView = OutputView(OutputViewResolver())
    val numberGenerator = RandomNumberGenerator()

    val carRacingGameManager = CarRacingGameManager(inputView, outputView, numberGenerator)
    carRacingGameManager.gameStart()
}

class CarRacingGameManager(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator,
) {
    fun gameStart() {
        val totalCar = inputView.inputTotalCar()
        val totalRound = inputView.inputTotalRound()
        val minConditionToMove = 4

        val cars = Cars.create(totalCar, 0, minConditionToMove)
        for (currentRound in 0 until totalRound) {
            cars.moveAllCars(numberGenerator)
            val carPositions = cars.getCarPositions()
            outputView.printRaceResult(carPositions)
        }
    }
}
