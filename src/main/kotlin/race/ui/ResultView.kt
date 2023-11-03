package race.ui

import race.domain.RacingCar
import race.domain.RacingResult

class ResultView() {
    fun showResult(result: RacingResult) {
        showStart()
        showRounds(result.rounds)
        showWinner(result.getWinners())
    }

    private fun showStart() {
        println("실행 결과")
    }

    private fun showRounds(result: List<List<RacingCar>>) {
        result.forEach { showRound(it) }
    }

    private fun showRound(round: List<RacingCar>) {
        round.forEach { showSpace(car = it) }
        showNewLine()
    }

    private fun showWinner(winners: List<RacingCar>) {
        println("${winners.joinToString(",") { it.name }}가 최종 우승했습니다.")
    }

    private fun showNewLine() = println("")

    private fun showSpace(car: RacingCar) = println("${car.name} : ${"-".repeat(car.space)}")
}
