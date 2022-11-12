package racingcar

data class Car(val name: String = "", private var _progress: Int = 0) : MoveStrategy() {

    val progress
        get() = _progress

    fun move() {
        if (this.canMove()) {
            _progress += 1
        }
    }
}
