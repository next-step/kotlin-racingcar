package model

import view.ResultView

class Game {
    fun start() {
        val numOfCars = askNumOfCars()
        val numOfRounds = askNumOfRounds()

        val race = Race(numOfCars)
        val resultView = ResultView()

        repeat(numOfRounds) {
            resultView.record(race.doRace())
        }
        resultView.showResult()
    }

    private fun askNumOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toInt()
    }

    private fun askNumOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
