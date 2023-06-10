package step3

import step3.view.InputView
import step3.view.OutputView

fun main() {
    val requirement = InputView.askRequirement()

    val cars = arrangeCars(requirement)

    val racing = Racing(cars = cars)

    OutputView.showResultTitle()
    repeat(requirement.numberOfTrials) {
        racing.race()
        OutputView.showStatus(racing.showCurrentStatus())
    }
}

private fun arrangeCars(requirement: RacingRequirement): List<Car> {
    return buildList {
        repeat(requirement.numberOfCars) {
            this.add(Car(ConditionalOperatingCarEngine.RANDOM))
        }
    }
}
