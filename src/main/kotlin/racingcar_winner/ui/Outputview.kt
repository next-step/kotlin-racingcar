package racingcar_winner.ui

import racingcar_winner.model.Cars
import racingcar_winner.model.Winner
import racingcar_winner.util.progressNumberToBar

class Outputview {
    fun printProgressOfCars(gameRecord: String) {
       print(gameRecord)
    }

    fun printWinner(winners: List<String>) {
        println("우승자 : ${winners.joinToString(", ")}")
    }
}
