package racingcar_winner

class Car(
    var name: String
) {
    var progress: Int = 0
        private set

    fun moveToForward() {
        progress += 1
    }
}
