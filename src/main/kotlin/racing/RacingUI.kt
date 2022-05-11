package racing

class RacingUI {

    fun drawCars(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position + 1)}")
        }
        println()
    }
}
