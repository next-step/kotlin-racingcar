package racing

class RacingUI {

    fun drawCars(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position + 1)}")
        }
        println()
    }

    fun drawWinners(winners: List<Car>) {
        val winnerMessage = winners
            .joinToString(separator = ", ", postfix = "가 최종 우승했습니다.") {
                it.name
            }
        println(winnerMessage)
    }
}
