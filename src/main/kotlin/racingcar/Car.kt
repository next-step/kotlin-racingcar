package racingcar

data class Car(private var progress: Int = 0) {

    fun go() {
        progress += 1
    }

    fun now(): Int = progress
}
