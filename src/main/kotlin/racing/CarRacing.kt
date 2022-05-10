package racing

class CarRacing {
    fun startRacing() {
        val (carCount, moveCount) = CarRacingInputView().input()

        moveCars(carCount = carCount, moveCount = moveCount)
    }

    fun moveCars(carCount: Int, moveCount: Int) {
        val cars: List<Car> = createCars(carCount)

        cars.forEach { car ->
            printCurrentCarMovingDistance(car.currentPosition)
        }
        println()

        for (moveIndex in 0 until moveCount) {
            cars.forEach { car ->
                car.go()

                printCurrentCarMovingDistance(car.currentPosition)
            }
            println()
        }
    }

    fun createCars(carCount: Int): List<Car> {
        val cars = arrayListOf<Car>()
        for (index in 0 until carCount) {
            cars.add(Car())
        }

        return cars
    }

    fun printCurrentCarMovingDistance(carPosition: Int) {
        for (i in 0 until carPosition) {
            print("_ ")
        }
        println()
    }
}
