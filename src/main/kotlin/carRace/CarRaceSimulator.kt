package carRace

class CarRaceSimulator(
    private val inputView: InputView,
    private val resultView: ResultView = ResultView()
) {
    fun simulate(carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()): CarRaceResult {
        val (carNames, iterationCount) = inputView.carsProvider.provide()

        val carRaceResult = CarRaceResult(
            carNames.map { Car(it, 0, carMovingStrategy) }
        )

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
