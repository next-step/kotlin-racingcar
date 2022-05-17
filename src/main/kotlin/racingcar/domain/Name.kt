package racingcar.domain

private const val MIN_NAME_LENGTH = 1
private const val MAX_NAME_LENGTH = 5

@JvmInline
value class Name(val value: String) {
    init {
        require(value.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { " 이름은 최소 1글자 이상 최대 5글자 이하만 허용됩니다. value = $value" }
    }
}
