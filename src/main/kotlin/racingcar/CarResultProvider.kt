package racingcar

interface CarResultProvider {
    fun printCars(cars: List<Car>)

    fun printWinners(cars: List<Car>)
}
