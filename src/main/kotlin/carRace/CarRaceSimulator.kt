package carRace

class CarRaceSimulator(
    private val inputView: InputView,
    private val resultView: ResultView = ResultView()
) {
    fun simulate(carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()): CarRaceResult {
        val carList = inputView.carsProvider.provide(carMovingStrategy)
        val iterationCount = inputView.iterationProvider.provide()

        val carRaceResult = CarRaceResult(carList)

        repeat(iterationCount) {
            carRaceResult.driveCars(it + 1)
        }

        resultView.printResult(carRaceResult)
        return carRaceResult
    }
}

fun main() {
    CarRaceSimulator(UserInputView()).simulate()
}
