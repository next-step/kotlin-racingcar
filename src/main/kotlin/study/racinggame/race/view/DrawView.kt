package study.racinggame.race.view

import study.racinggame.domain.CarResponse

class DrawView {

    init {
        println("실행 결과")
    }

    fun drawCarState(carResponses: List<CarResponse>) {
        for (response in carResponses) {
            println(response.getPositionRepresentation())
        }
        println()
    }

    fun drawRaceWinner(winnerName: String) {
        println("${winnerName}님이 최종 우승했습니다.")
    }
}
