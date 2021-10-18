package racing

class Cars(val cars: List<Car>) {

    init {
        require(cars.isNotEmpty()) { "Car는 하나 이상 존재해야합니다" }
    }

    fun goAll() {
        cars.forEach(Car::go)
    }
}
