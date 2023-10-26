object CarRaceSimulator {
    fun simulate() {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readln().trim().toInt()
        println("시도할 횟수는 몇 회인가요?")
        val iterationCount = readln().trim().toInt()

        val carList = CarList(MutableList(carCount) { Car(0) })

        for (i in 0 until iterationCount) {
            carList.driveCars()
            carList.printCars()
        }
    }

    data class Car(val traveled: Int)

    class CarList(private val cars: MutableList<Car>) {

        fun driveCars() {
            for (n in 0 until cars.size) {
                cars[n] = cars[n].drive()
            }
        }

        fun printCars() {
            cars.forEach { car ->
                car.print()
            }
            println()
        }

        private fun Car.drive() = if ((0..9).random() >= 4) {
            copy(traveled = traveled + 1)
        } else this

        private fun Car.print() = println("-".repeat(traveled))
    }
}
