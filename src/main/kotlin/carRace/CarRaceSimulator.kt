package carRace

class CarRaceSimulator(
    private val inputView: InputView,
    private val resultView: ResultView = ResultView()
) {
    fun simulate(carMovingStrategy: CarMovingStrategy = RandomMovingStrategy()): CarList {
        val (carCount, iterationCount) = inputView.raceRegulationProvider.provide()

        val carList = CarList(MutableList(carCount) { Car(0, carMovingStrategy) })

        for (i in 0 until iterationCount) {
            carList.driveCars()
        }
        resultView.printCars(carList.cars)
        return carList
    }
}

fun main() {
    CarRaceSimulator(UserInputView()).simulate()
}
