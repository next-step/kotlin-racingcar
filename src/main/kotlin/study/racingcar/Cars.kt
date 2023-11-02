package study.racingcar

data class Cars(private val cars: List<Car>) {

    val list: List<Car> get() = cars.toList()

    fun moveAll(randomValueGenerator: () -> Int): Cars {
        return Cars(
            cars.map { car ->
                Car(car.position).apply { move(randomValueGenerator()) }
            },
        )
    }
}
