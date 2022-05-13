package step3

object OutputView {
    fun printRace(race: Race) {
        race.cars.forEach {
            println(it.toString())
        }
        println()
    }
}
