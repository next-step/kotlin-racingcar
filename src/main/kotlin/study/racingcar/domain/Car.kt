package study.racingcar.domain

data class Car(
    val name: String,
    var position: Int = 0
) {

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
