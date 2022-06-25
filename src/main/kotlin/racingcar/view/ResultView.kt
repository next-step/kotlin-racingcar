package racingcar.view

import racingcar.domain.record.RaceRecord

object ResultView {
    fun showResult(raceRecord: RaceRecord) {
        println("\n[실행 결과]")
        raceRecord.record.map { cars ->
            cars.positions.map { position ->
                (0 until position.value).map { print("-") }
                println("")
            }
            println("")
        }
        println("")
    }
}
