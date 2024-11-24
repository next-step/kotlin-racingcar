package week1.step4.racinggame.domain

@JvmInline
value class CarName(val value: String) {
    init {
        require(value.isNotBlank()) {
            "자동차의 이름은 빈 문자열일 수 없습니다"
        }

        require(value.length <= 5) {
            "자동차의 이름은 5글자까지 허용합니다"
        }
    }
}
