package racingcar_winner.ui

class Outputview {

    fun printOneRound(progressCars: List<String>) {
        for (car in progressCars) {
            println(car)
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("우승자 : ${winners.joinToString(", " )}")
    }
}