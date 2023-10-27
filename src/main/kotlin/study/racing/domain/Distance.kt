package study.racing.domain

class Distance {

    private var moveDistance: Int = 0

    fun moveForward() {
        this.moveDistance += 1
    }

    fun getDistance(): Int {
        return this.moveDistance
    }
}
