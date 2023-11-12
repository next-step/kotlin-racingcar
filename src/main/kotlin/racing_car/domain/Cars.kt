package racing_car.domain

class Cars(
    private val cars: List<Car>,
) {

    init {
        require(cars.size >= 2) { "경주에 필요한 자동차 대수는 2대 이상입니다." }
    }

    val carInfos
        get() = cars.map { it.carInfo }

    fun moveAll() {
        cars.forEach(Car::move)
    }

    fun getWinningCars() = cars.filter { car ->
        cars.all { otherCar ->
            car.isWin(otherCar) || car.isDraw(otherCar)
        }
    }
}
