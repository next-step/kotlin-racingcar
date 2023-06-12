package study.racinggame.presentation.view

import study.racinggame.presentation.dto.CarResponse

interface OutputFormat {
    fun drawCarState(carResponses: List<CarResponse>)
    fun drawRaceWinner(winnerName: String)
}
