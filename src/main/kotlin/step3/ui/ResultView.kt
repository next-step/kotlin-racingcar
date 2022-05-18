package step3.ui

import step3.Round

object ResultView {
    private val initValue = 1 // 출발 선상있을 때 한칸으로 보일지 안보일지 모름.
    private val carChar = '-'

    fun show(raceSeriesResult: List<Round>, carCount: Int) {
        val raceResult = List(carCount) { initValue }
        val accumulatedRacePoint = raceSeriesResult
            .map { round -> round.raceResult.map { if (it.forward) 1 else 0 } }
            .runningFold(raceResult) { total, round -> total.mapIndexed { index, it -> it + round[index] } }
            .drop(1)

        println("실행 결과")
        accumulatedRacePoint.map { roundPoint ->
            roundPoint.map {
                (0 until it).map { print(carChar) }
                println()
            }
            println()
        }
    }
}