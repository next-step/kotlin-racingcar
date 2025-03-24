package racingcar.view

object OutputView {
    fun printCarStatus(cars: List<CarDto>) {
        cars.forEach {
            println("${it.name}: ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("🏆 Winners: ${winners.joinToString(", ")} 🏆")
    }
}
