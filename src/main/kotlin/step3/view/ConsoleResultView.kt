package step3.view

import step3.domain.race.RaceResult

class ConsoleResultView : ResultView {
    override fun drawResult(raceResult: RaceResult) {
        println("실행결과")
        raceResult.roundResultList.forEach {
            carList ->
            carList.carStatusList.forEach {
                car ->
                println("[${car.id}]" + "-".repeat(car.position))
            }
            println()
        }
    }
}
