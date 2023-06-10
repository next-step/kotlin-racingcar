package step3

import step3.view.InputView
import step3.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val requirement = inputView.askRequirement()

        val cars = arrangeCars(requirement)

        val racing = Racing(cars = cars)

        outputView.showResultTitle()
        repeat(requirement.numberOfTrials) {
            racing.race()
            outputView.showStatus(racing.showCurrentStatus())
        }
    }

    private fun arrangeCars(requirement: RacingRequirement): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(requirement.numberOfCars) {
            cars.add(Car(ConditionalOperatingCarEngine.RANDOM))
        }
        return cars
    }
}
