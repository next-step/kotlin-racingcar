package racing.model

data class Car(
    val driver: Driver,
    val mileage: Int = 0,
)

@JvmInline
value class Driver(
    val name: String
)
