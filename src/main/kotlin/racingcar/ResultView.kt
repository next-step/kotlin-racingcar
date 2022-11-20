package racingcar

object ResultView {
    fun printLocation(cars: List<Car>) {
        for (car in cars) {
            val location = car.location
            print(car.name + " : ")
            repeat(location) { print("-") }
            println()
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        println("${cars.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
