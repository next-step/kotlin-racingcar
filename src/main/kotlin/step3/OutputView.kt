package step3

object OutputView {
    fun printRace(race: Race) {
        race.cars.forEach {
            println(formatPosition(it))
        }
        println()
    }
    fun formatPosition(car: Car): String {
        return "-".repeat(car.position)
    }
}
