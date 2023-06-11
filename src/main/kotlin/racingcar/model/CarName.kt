package racingcar.model

@JvmInline
value class CarName(private val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "car name must be less than $MAX_NAME_LENGTH characters. but provided name(`$name`)" }
    }

    companion object {
        private const val MAX_NAME_LENGTH: Int = 5
    }

    override fun toString(): String {
        return name
    }
}
