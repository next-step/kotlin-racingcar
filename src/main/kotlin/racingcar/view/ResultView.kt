package racingcar.view

import racingcar.domain.Car

object ResultView {
    private const val MARK = "-"
    private const val COMMA = ","

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printTraceOfRound(round: Int, cars: List<Car>) {
        println("[ROUND ${round + 1}]")
        cars.forEach { car ->
            print("${car.name.value} : ")
            repeat(car.distance) {
                print(MARK)
            }
            println()
        }
        println()
    }

    fun printWinner(winner: List<Car>) {
        winner.forEachIndexed { index, car ->
            if (index != 0) print("$COMMA ")
            print(car.name.value)
        }
        println("가 최종 우승했습니다.")
    }
}
