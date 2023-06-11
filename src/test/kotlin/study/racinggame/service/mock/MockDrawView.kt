package study.racinggame.service.mock

import study.racinggame.presentation.dto.CarResponse
import study.racinggame.presentation.view.OutputFormat

class MockDrawView : OutputFormat {

    init {
        println("실행 결과")
    }

    override fun drawCarState(carResponses: List<CarResponse>) {
        println("drawCarState is Called")
    }

    override fun drawRaceWinner(winnerName: String) {
        println("drawRaceWinner is Called")
    }
}
