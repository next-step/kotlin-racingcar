package view

import Cars

/**
 * 자동차 경주에서 게임 중 혹은 결과를 출력 모음 class
 * */
class ResultView {
    companion object {
        const val RESULT_TITLE = "실행 결과"
    }

    fun printResultTitle(title: String) {
        println()
        println(title)
    }

    private fun printStartRound(round: Int) {
        println("ROUND: $round")
    }

    private fun printEndRound() {
        println("")
    }

    private fun printMovement(id: Int, move: Int) {
        val step = StringBuffer("$id: ")
        for (i in 1..move) {
            step.append("\uD83D\uDE80")
        }
        println(step)
    }

    /**
     * 경주 시작 메소드
     * */
    fun printRace(carCount: Int, tryCount: Int) {
        val list = Cars(carCount).createCars()
        for (i in 1..tryCount) {
            printStartRound(i)
            list.forEachIndexed { index, car ->
                car.move()
                printMovement(index + 1, car.movement)
            }
            printEndRound()
        }
    }
}
