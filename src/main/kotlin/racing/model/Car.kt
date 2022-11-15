package racing.model

data class Car(
    val carName: CarName,
    val mileage: Int = 0,
)

@JvmInline
value class CarName(
    val name: String
) {
    init {
        require(name.length <= LIMIT_DRIVER_NAME_LENGTH) {
            "운전자 이름은 5자 초과하지 않습니다. $name"
        }
    }

    companion object {
        private const val LIMIT_DRIVER_NAME_LENGTH = 5
    }
}
