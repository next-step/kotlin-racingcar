package racing

@JvmInline
value class CarCount(val value: Int) {
    init {
        require(value > 0) { "차는 1대 이상 필요합니다" }
    }

    fun <T> repeat(transform: () -> T) = (1..value).map { transform() }
}

object CarsFactory {

    private val engine = RandomEngine

    fun create(count: CarCount): Cars {
        val cars = count.repeat { Car(engine) }
        return Cars(cars)
    }
}
