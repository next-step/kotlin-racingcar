package racingcar.model

private const val NAME_LENGTH_LIMIT = 5

class Name(val value: String) {

    init {
        require(value.isNotBlank())
        require(value.length <= NAME_LENGTH_LIMIT)
    }
}
