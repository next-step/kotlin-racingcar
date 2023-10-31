package camp.nextstep.edu.step.racing.domain

import camp.nextstep.edu.step.racing.service.CarService

@JvmInline
value class Cars private constructor(
    val cars: List<Car>
) {

    init {
        require(cars.isNotEmpty()) { "참여하는 자동차들이 없습니다." }
    }

    fun getCarsSize(): Int {
        return cars.size
    }

    fun getFirstCar(): Car {
        return cars.first()
    }

    fun moveCarsByMoveStrategy(carService: CarService) {
        cars.forEach { car ->
            carService.carMoveByMoveStrategy(car = car)
        }
    }

    fun getWinners(): Cars {
        val winnerCar = cars.maxByOrNull { car -> car.position }!!

        val getWinners =
            cars.filter { car -> car.position == winnerCar.position }

        return Cars(cars = getWinners)
    }

    companion object {
        fun of(cars: List<Car>): Cars {
            return Cars(cars = cars)
        }
    }

}
