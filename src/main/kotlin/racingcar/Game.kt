package racingcar

class Game {
    val cars = mutableListOf<Car>()

    fun makeCar(number: Int) {
        for (num in 1..number) {
            val car = Car()
            cars.add(car)
        }
    }
}
