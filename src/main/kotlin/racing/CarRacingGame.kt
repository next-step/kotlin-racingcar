package racing

fun main() {
    val (carCountStr: String?, tryCountStr: String?) = InputView.getInput()
    val (carCount: Int, tryCount: Int) = InputView.validateInput(carCountStr, tryCountStr)
    val cars: List<Car> = createCars(carCount)

    repeat(tryCount) {
        executeOneTry(cars)
    }
}

private fun createCars(carCount: Int) = List(carCount) { Car() }

private fun executeOneTry(cars: List<Car>) {
    cars.forEach {
        it.moveForward(RandomNumberGenerator.generate(0, 9))
        ResultView.printPosition(it.position)
    }
    println()
}
