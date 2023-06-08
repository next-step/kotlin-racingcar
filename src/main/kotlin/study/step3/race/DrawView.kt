package study.step3.race

import study.step3.domain.CarResponse

class DrawView(
    private val totalRaceCount: Int
) {
    init {
        println("실행 결과")
    }

    fun drawCarState(carResponses: List<CarResponse>, raceIdx: Int) {
        for (response in carResponses) {
            println(response.getPositionRepresentation())
        }

        if (totalRaceCount != raceIdx) println()
    }
}
