package carracing.domain

class Name(val name: String) {

    init {
        require(name.length <= MAX_CAR_LENGTH) { "자동차 이름의 길이는 $MAX_CAR_LENGTH 이하여야 합니다." }
    }
}
