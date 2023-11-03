package study.view

import study.domain.RaceCar

object ResultView {
    fun showRaceResult(winners: List<RaceCar>, resultOfEachRound: Map<Int, List<RaceCar>>) {
        println("실행 결과")
        resultOfEachRound.forEach(this::printEachRound)
        println()
        print("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다")
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
