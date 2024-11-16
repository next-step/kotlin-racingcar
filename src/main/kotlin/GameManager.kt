import UserInputType.ATTEMPT_COUNT
import UserInputType.NUMBER_OF_CARS
import ui.InputView

class GameManager {
    lateinit var inputView: InputView

    fun start() {
        val numberOfCar = inputView.readUserInput(NUMBER_OF_CARS)
        val attemptCount = inputView.readUserInput(ATTEMPT_COUNT)
    }

    fun createRacingCar(numberOfCar: Int) = List(numberOfCar) { Car(id = it + 1) }
}
