package racing

class Cars(val cars: List<Car>) {

    init {
        require(cars.isNotEmpty()) { "Car는 하나 이상 존재해야합니다" }
    }

    fun goAll() {
        cars.forEach(Car::go)
    }

    fun getWinner(): Cars {
        val winner = cars.reduce { acc, car ->
            getWinningCar(acc, car)
        }
        return Cars(cars.filter { it.isDrawWith(winner) })
    }

    private fun getWinningCar(car: Car, other: Car): Car {
        return if (car.isAheadOf(other)) {
            car
        } else {
            other
        }
    }
}
