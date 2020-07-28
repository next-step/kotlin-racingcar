package week1.step3

fun main() {
    val (carNames, tryCount) = InputView.getCarNamesAndTryCount()
    val racingCar = mutableListOf<Car>().apply {
        for (name in carNames) {
            add(Car(name))
        }
    }

    // val racingStep = startRacing(racingCar, tryCount)

    // showRacingStep(carCount, racingStep)
}

private fun startRacing(racingCar: Array<Car>, tryCount: Int): List<Int> {
    val racingStep = mutableListOf<Int>()

    repeat(tryCount) {
        racingCar.forEach { it.updateForwardCount() }
        for (car in racingCar) {
            racingStep.add(car.forwardCount)
        }
    }
    return racingStep
}

private fun showRacingStep(carCount: Int, racingStep: List<Int>) {
    ResultView.printRacingStep(carCount, racingStep)
}
