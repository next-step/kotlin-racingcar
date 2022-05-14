import Constants.RESULT_MESSAGE

fun main() {
    val inputParams = CarRacingInputHandler.input()
    CarRacingInputHandler.validate(inputParams.numberOfCars, inputParams.numberOfTries, inputParams.carNames)

    val cars = CarRacingInputHandler.getCars(inputParams.numberOfCars)

    println(RESULT_MESSAGE)

    repeat(inputParams.numberOfTries.toInt()) {
        RacingGame.play(cars, RandomMovingStrategy())
        CarRacingOutputHandler.display(cars)
    }
}
