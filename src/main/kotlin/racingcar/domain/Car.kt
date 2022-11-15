package racingcar.domain

const val MAX_CAR_NAME_LENGTH = 5

class Car(
    var route: Int = 0,
    val name: String = ""
) {
    fun move() {
        this.route += 1
    }

    fun valid() {
        require(name.length < MAX_CAR_NAME_LENGTH) { "차 이름은 5자를 넘으면 안 됩니다." }
    }

    companion object {

        fun generateCarByName(names: List<String>) = names.map { Car(name = it) }

        fun generateCarByCount(count: Int) = buildList {
            repeat(count) { add(Car()) }
        }
    }
}
