package carrace.view

import carrace.logic.car.CarInfos

interface ResultView {
    fun displayGameResult(gameLog: List<CarInfos>)
    fun displayWinner(winnersInfos: CarInfos)
}
