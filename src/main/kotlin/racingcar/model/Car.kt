package racingcar.model

data class Car(val name: String) {

    init {
        require(name.length <= 5) { "차 이름은 최대 5글자까지 가능합니다." }
    }

    companion object {
        private const val MAX_CAR_NAME = 5
    }
}
