import Constants.CAR_INPUT_MESSAGE
import Constants.TRIES_INPUT_MESSAGE

class CarRacingInputHandler {
    companion object {
        fun input(): InputParams {
            displayCarMessage()
            val numberOfCar = readln()

            displayTriesMessage()
            val numberOfTries = readln()

            return InputParams(numberOfCar, numberOfTries)
        }

        private fun displayCarMessage() {
            println(CAR_INPUT_MESSAGE)
        }

        private fun displayTriesMessage() {
            println(TRIES_INPUT_MESSAGE)
        }

        fun validate(numberOfCar: String, numberOfTries: String) {
            require(numberOfCar.isNotEmpty() && numberOfTries.isNotEmpty()) { Constants.INVALID_ARGUMENT_MESSAGE }
            require(numberOfCar.toIntOrNull() != null && numberOfTries.toIntOrNull() != null) { Constants.INVALID_ARGUMENT_MESSAGE }
        }

        fun getCars(numberOfCar: String): List<Car> {
            return List(numberOfCar.toInt()) { Car() }
        }
    }
}
