package racingcar.domain

data class Car(
    val name: String,
    val position: Int = 1,
) {

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }

    fun move(point: Int): Car {
        if (point >= 4) {
            return copy(position = position + 1)
        }
        return this
    }
}
