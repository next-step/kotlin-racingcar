package study.racingcar

data class Cars(private val cars: List<Car>) {

    val list: List<Car> get() = cars.toList()
}
