package model

import view.CarResultView

class Game {
    fun start() {
        val numOfCars = askNumOfCars()
        val numOfRounds = askNumOfRounds()

        val race = Race(numOfCars)

        for (i in 1..numOfRounds) {
            CarResultView(race.doRace()).display()
        }
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
