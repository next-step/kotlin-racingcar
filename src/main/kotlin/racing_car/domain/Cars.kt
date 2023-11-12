package racing_car.domain

class Cars(
    val cars: List<Car>,
) {

    init {
        require(cars.size >= 2) { "경주에 필요한 자동차 대수는 2대 이상입니다." }
    }

    fun moveAll() {
        cars.forEach(Car::move)
    }

    fun getWinningCars() = cars.filter { car ->
        cars.all { otherCar ->
            car.isWin(otherCar) || car.isDraw(otherCar)
        }
    }
}
