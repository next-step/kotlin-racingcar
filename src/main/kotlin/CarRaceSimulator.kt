object CarRaceSimulator {
    fun simulate(provideMethod: CarListProvideMethod) {
        val (carCount, iterationCount) = provideMethod.provide()

        val carList = CarList(MutableList(carCount) { Car(0) })

        for (i in 0 until iterationCount) {
            carList.driveCars()
            carList.printCars()
        }
    }

    sealed interface CarListProvideMethod {
        fun provide(): Pair<Int, Int>
        class Manual(private val carCount: Int, private val iterationCount: Int) : CarListProvideMethod {
            override fun provide(): Pair<Int, Int> = Pair(carCount, iterationCount)
        }

        object UserInput : CarListProvideMethod {
            override fun provide(): Pair<Int, Int> {
                val carCount = println("자동차 대수는 몇 대인가요?").run { readln().trim().toInt() }
                val iterationCount = println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
                return Pair(carCount, iterationCount)
            }
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
