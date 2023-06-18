package racingcar.view

import racingcar.dto.RaceResult

class OutputView : OutputViewProtocol {

    override fun printLocation(location: Int) {
        for (i in 0 until location) {
            print("-")
        }
        println()
    }

    override fun printName(name: String) {
        print("$name : ")
    }

    override fun printRaceWinner(raceResult: RaceResult) {
        val result = raceResult.winnerNameSet
        result.forEachIndexed { index, str ->
            print(str)
            if (index != result.size - 1) {
                print(", ")
            }
        }
        println("가 최종 우승했습니다.")
    }

    override fun printNextLine() {
        println()
    }
}
