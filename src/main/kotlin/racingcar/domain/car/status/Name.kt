package racingcar.domain.car.status

private const val MAX_CAR_NAME_LENGTH = 5

data class Name(val name: String) {
    init {
        require(!(name.isEmpty() || name.contains(" "))) { "이름에 빈 문자열이거나 공백이 있습니다." }
        require(name.length <= MAX_CAR_NAME_LENGTH) { "이름은 5글자 이하만 가능합니다." }
        require(name.matches("^[a-zA-Z]*$".toRegex())) { "이름은 알파벳만 가능합니다." }
    }
}
