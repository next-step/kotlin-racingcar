package study.view

import study.domain.RaceCar
import study.domain.RaceResult

object ResultView {
    fun showRaceResult(raceResult: RaceResult) {
        println("실행 결과")
        raceResult.getResult().forEach(this::printEachRound)
        println()
        print("${raceResult.winners.joinToString(", ") { it.name }}가 최종 우승했습니다")
    }

    private fun printEachRound(round: Map.Entry<Int, List<RaceCar>>) {
        println("${round.key}번째 시도")
        round.value.forEach { car ->
            print(car.name + " : ")
            repeat(car.position) {
                print("-")
            }
            println()
        }
    }
}
