package racingcar_winner.ui

class Outputview {
    fun printProgressOfCars(gameRecord: String) {
        print(gameRecord)
    }

    fun printWinner(winners: List<String>) {
        println("우승자 : ${winners.joinToString(", ")}")
    }
}
