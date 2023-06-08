package study.racinggame.domain

class Car(
    var position: Int = 0
) {
    fun moveForward(randomNumber: Int) {
        if (randomNumber > FORWARD_THRESHOLD) position += 1
    }

    companion object {
        private const val FORWARD_THRESHOLD = 3
    }
}
