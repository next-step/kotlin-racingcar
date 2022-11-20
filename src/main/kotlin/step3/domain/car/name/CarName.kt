package step3.domain.car.name

class CarName(
    val name: String
) {
    init {
        require(DEFAULT_CAR_NAME_POLICY(name)) {
            "Invalid car name length should be less than $MAX_CAR_NAME_LENGTH [$name]"
        }
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
        val DEFAULT_CAR_NAME_POLICY: (String) -> Boolean = { it.length <= MAX_CAR_NAME_LENGTH }
    }
}
