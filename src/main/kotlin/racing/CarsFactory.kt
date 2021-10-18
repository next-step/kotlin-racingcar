package racing

@JvmInline
value class CarCount(val value: Int) {
    init {
        require(value > 0) { "차는 1대 이상 필요합니다" }
    }
}

object CarsFactory {

    private val engine = RandomEngine

    fun getCars(count: CarCount): Cars {
        val cars = (1..count.value).map { Car(engine) }
        return Cars(cars)
    }
}
