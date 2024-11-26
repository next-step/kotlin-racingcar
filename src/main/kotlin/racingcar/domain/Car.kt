package racingcar.domain

class Car(var position: Position, val username: String) {
    fun move(number: Int) {
        this.position = position.move(number)
    }

    companion object {
        fun init(username: String): Car {
            return Car(Position.init(), username)
        }
    }
}
