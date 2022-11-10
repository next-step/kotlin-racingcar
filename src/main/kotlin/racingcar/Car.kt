package racingcar

data class Car(val name: String = "", private var _progress: Int = 0) {

    val progress
        get() = _progress

    fun go() {
        _progress += 1
    }
}
