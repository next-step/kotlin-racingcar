package study.racing.domain

class Distance {

    var moveDistance: Int = 0
        private set

    fun moveForward() {
        this.moveDistance += 1
    }
}
