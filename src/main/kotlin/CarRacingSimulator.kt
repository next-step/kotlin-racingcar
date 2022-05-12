import Constants.RESULT_MESSAGE

fun main() {
    val (numberOfCar, numberOfTries) = CarRacingInputHandler.input()
    CarRacingInputHandler.validate(numberOfCar, numberOfTries)

    val cars = CarRacingInputHandler.getCars(numberOfCar)

    println(RESULT_MESSAGE)

    repeat(numberOfTries.toInt()) {
        RacingGame.play(cars, RandomMovingStrategy())
        CarRacingOutputHandler.display(cars)
    }
}
