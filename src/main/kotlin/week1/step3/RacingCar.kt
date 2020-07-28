package week1.step3

fun main() {
    val (carNames, tryCount) = InputView.getCarNamesAndTryCount()
    val racingCar = mutableListOf<Car>().apply {
        for (name in carNames) {
            add(Car(name))
        }
    }

    val racingStep = startRacing(racingCar, tryCount)

    showRacingStep(racingCar.map { it.name }, racingStep)
}

private fun startRacing(racingCar: List<Car>, tryCount: Int): List<Int> {
    val racingStep = mutableListOf<Int>()

    repeat(tryCount) {
        racingCar.forEach { it.updateForwardCount() }
        for (car in racingCar) {
            racingStep.add(car.forwardCount)
        }
    }
    return racingStep
}

private fun showRacingStep(carNames: List<String>, racingStep: List<Int>) {
    ResultView.printRacingStep(carNames, racingStep)
}
