package study.racing.domain

class CarName(
    carName: String
) {
    var name = carName
        private set

    init {
        require(carName.length < 5 && carName.isNotEmpty()) {
            "자동차 이름은 최대 4글자까지 가능합니다."
        }
    }
}
