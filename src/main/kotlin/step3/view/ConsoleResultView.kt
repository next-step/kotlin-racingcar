package step3.view

import step3.domain.race.RaceResult

class ConsoleResultView : ResultView {
    override fun drawResult(raceResult: RaceResult) {
        println("실행결과")
        raceResult.roundResults.forEach {
            raceRoundResult ->
            raceRoundResult.carStatuses.forEach {
                car ->
                println("[${car.key}]" + "-".repeat(car.value.position))
            }
            println()
        }
    }
}
