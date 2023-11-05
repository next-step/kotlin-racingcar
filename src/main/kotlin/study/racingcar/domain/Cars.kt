package study.racingcar.domain

class Cars(private val cars: List<Car>) {
    val list: List<Car> get() = cars.toList()

    fun moveAll(randomValueGenerator: RandomValueGenerator): Cars = Cars(
        list.map { it.move(randomValueGenerator()) }
    )
}
