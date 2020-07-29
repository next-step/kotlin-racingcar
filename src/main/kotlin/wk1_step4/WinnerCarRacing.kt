package wk1_step4

import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException

class WinnerCarRacing(private val input: String) {

    init {
        parsingCars(input)
    }

    private lateinit var cars: List<Car>

    private fun generateRandomNumber(): Int {
        return (Math.random() * 10).toInt()
    }

    @Throws(NullPointerException::class)
    private fun moveOrStop(car: Car) {
        if (generateRandomNumber() > 3) car.position = car.position + 1
    }

    fun updateCarRacing(): List<Car> {
        if (cars.isEmpty()) {
            throw WinnerCarRacingException("자동차 이름을 입력하세요.")
        }
        for (car in cars) {
            moveOrStop(car)
        }
        return cars
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getMaxDistance(cars: List<Car>): Int {
        return cars.maxBy { it.position }!!.position
    }

    @Throws(IndexOutOfBoundsException::class)
    fun findWinners(): List<Car> {
        return cars.filter { it.position == getMaxDistance(cars) }
    }

    fun parsingCars(input: String) {
        val names = input.split(",")
        var nameLength: Int = 0
        val cars = mutableListOf<Car>()
        for (name: String in names) {
            nameLength = name.length.coerceAtLeast(nameLength)
            cars.add(Car(name, 0))
        }
        if (nameLength > 5) {
            throw WinnerCarRacingException("자동차 이름은 5자를 넘어갈 수 없습니다.")
        }
        this.cars = cars
    }
}
