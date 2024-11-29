package racinggame.ui

import racinggame.domain.RacingCar

class ResultView {
    fun printInitialMessage() {
        println("실행결과\n")
    }

    fun printResultOfTurn(
        turn: Int,
        cars: List<RacingCar>,
    ) {
        println("$turn 회 결과")
        cars.forEach { racingCar ->
            println("${racingCar.carName} 자동차 현재위치는 ${racingCar.getCurrentPosition()} 입니다.")
        }
        println("----------------------------------------------------")
    }

    fun printWinners(winners: List<RacingCar>) {
        val winnersNames = StringBuilder()
        winners.forEachIndexed { index, car ->
            if (index == winners.lastIndex) {
                winnersNames.append(car.carName)
            } else {
                winnersNames.append("${car.carName}, ")
            }
        }
        println("${winnersNames}가 최종 우승했습니다.")
    }
}
