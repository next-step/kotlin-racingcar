package carRace

class ResultView {
    fun printCars(cars: List<Car>) {
        cars.forEach { car ->
            car.print()
        }
        println()
    }
    private fun Car.print() = println("-".repeat(traveled))
}