package racingcar.domain.model

class Car(val name: String, position: Int = 0) {

    var position: Int = position
        private set

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun moveTo(count: Int) {
        if (count >= 4) position++
    }

    fun copy(): Car {
        return Car(name, position)
    }
}
