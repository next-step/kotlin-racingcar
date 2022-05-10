package racing

class CarRacing {
    fun input() {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = readLine()!!.toInt()

        // 실행
        startRacing(carCount = carCount, moveCount = moveCount)
    }

    fun startRacing(carCount: Int, moveCount: Int) {
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
