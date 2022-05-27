package study.racingcar.domain

class Car(val name: String, position: Int = 0) {

    var position = position
        private set

    init {
        require(name.length <= 5) { "name [$name]이 5글자를 초과하였습니다" }
    }

    fun move(condition: Int): Int {
        if (condition >= 4) {
            position++
        }

        return position
    }
}
