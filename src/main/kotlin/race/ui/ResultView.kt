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

    fun showWinner(
        winningCars: List<RacingCar>,
    ) {
        println("${winningCars.joinToString(",") { it.name }}가 최종 우승했습니다.")
    }

    private fun showNewLine() = println("")

    private fun showSpace(car: RacingCar) = println("${car.name} : ${"-".repeat(car.space)}")
}
