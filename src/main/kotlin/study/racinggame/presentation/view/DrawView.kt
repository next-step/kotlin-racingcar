package study.racinggame.presentation.view

import study.racinggame.presentation.dto.CarResponse

class DrawView : OutputFormat {

    init {
        println("실행 결과")
    }

    override fun drawCarState(carResponses: List<CarResponse>) {
        for (response in carResponses) {
            println(response.getPositionRepresentation())
        }
        println()
    }

    override fun drawRaceWinner(winnerName: String) {
        println("${winnerName}님이 최종 우승했습니다.")
    }
}
