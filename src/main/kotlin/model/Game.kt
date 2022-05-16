package model

import view.ResultView

class Game {
    fun start() {
        val names = askNamesOfCar()
        val numOfRounds = askNumOfRounds()

        val race = Race(names)
        val resultView = ResultView()

        repeat(numOfRounds) {
            race.doRace()
        }

        race.getRecords().forEach {
            resultView.showResult(it)
        }

        resultView.whoIsWinner(race.getRecords().last())
    }

    private fun askNamesOfCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()!!.split(",").map { it.trim() }
    }

    private fun askNumOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
