package race.ui

import race.domain.RacingCar

class ResultView {
    fun showStart() {
        println("실행 결과")
    }

    fun showResult(
        currentRacing: List<RacingCar>,
        isLast: Boolean = false,
    ) {
        currentRacing.forEach { showSpace(car = it) }

        if (!isLast) {
            showNewLine()
        }
    }

    private fun showNewLine() = println("")

    private fun showSpace(car: RacingCar) = println("${car.name} : " + "-".repeat(car.space))
}
