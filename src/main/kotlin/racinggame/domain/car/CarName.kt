package racinggame.domain.car

@JvmInline
value class CarName(val value: String) {
    init {
        require(value.isNotBlank() && value.length <= MAX_CAR_NAME_LENGTH) {
            "The name cannot be blank and must be up to $MAX_CAR_NAME_LENGTH characters. you input name : $value"
        }
    }

    companion object {

        private const val MAX_CAR_NAME_LENGTH = 5
    }
}

fun List<String>.toCarNames(): List<CarName> {
    return map { name -> CarName(name) }
}
