package study.racing.domain

class Distance(
    distance: Int = 0
) {
    var moveDistance = distance
        private set

    fun moveForward() {
        this.moveDistance += 1
    }
}
