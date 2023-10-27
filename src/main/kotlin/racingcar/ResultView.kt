package racingcar

object ResultView {

    fun printResult(cars: List<Car>): List<Car> {
        cars.forEach { car ->
            println(car.print())
        }
        println()
        return cars
    }
}
