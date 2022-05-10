package racing

class RacingUI {

    fun drawCars(cars: List<Car>) {
        cars.forEach {
            println("-".repeat(it.position + 1))
        }
        println()
    }
}
