package study.racing.domain

class CarName(
    val name: String
) {
    init {
        require(name.isNotEmpty()) {
            "자동차 이름은 공백으로 생성할 수 없습니다."
        }
        require(name.length < 5) {
            "자동차 이름은 최대 4글자까지 가능합니다."
        }
    }
}
