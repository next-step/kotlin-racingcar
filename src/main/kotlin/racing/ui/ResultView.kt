package racing.ui

import racing.domain.Car
import racing.domain.Cars

class ResultView {

    companion object {
        fun toRaceResult(cars: Cars): String {
            return cars.map { "${it.name} : ${toMark(it)}" }.joinToString(separator = System.lineSeparator()).trimIndent()
        }

        private fun toMark(car: Car): String {
            return MARK.repeat(car.position)
        }

        fun printRacingGameGuideText() {
            println("실행결과")
        }

        fun printRacingGameResult(result: String) {
            println(result)
        }

        fun printRacingGameWinner(winner: String) {
            println("${winner}가 최종 우승했습니다.")
        }

        const val MARK = "-"
    }
}
