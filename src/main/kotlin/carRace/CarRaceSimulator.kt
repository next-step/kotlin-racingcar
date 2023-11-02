package carRace

class CarRaceSimulator(
    private val inputView: InputView,
    private val resultView: ResultView = ResultView()
) {
    fun simulate(carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()): CarList {
        val (carNames, iterationCount) = inputView.carsProvider.provide()

        val carList = CarList(
            carNames.map { Car(it, 0, carMovingStrategy) }
        )

        repeat(iterationCount) {
            carList.driveCars()
        }
        resultView.printCars(carList.cars)
        return carList
    }
}

fun main() {
    CarRaceSimulator(UserInputView()).simulate()
}
