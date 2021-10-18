package racingcar.view

import racingcar.model.Car

/**
 * 자동차 경주에서 게임 중 혹은 결과를 출력 모음 class
 * */
class ResultView {
    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val ICON = "\uD83D\uDE80"
    }

    fun printResultTitle(title: String) {
        println()
        println(title)
    }

    fun printStartRound(round: Int) {
        println("ROUND: $round")
    }

    fun printEndRound() {
        println("")
    }

    fun printRace(list: List<Car>) {
        list.forEachIndexed { index, car ->
            val step = StringBuffer("${car.name}: ")
            for (i in 1..car.movement) {
                step.append(ICON)
            }
            println(step)
        }
    }

    fun printRaceResult(list: List<Car>) {
        val names = list.map { it.name }.joinToString { it }
        println("${names}가 최종 우승했습니다.")
    }
}
