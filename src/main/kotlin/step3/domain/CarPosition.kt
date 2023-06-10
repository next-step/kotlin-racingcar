package step3.domain

class CarPosition(val position: Int = 0) {
    fun move(): CarPosition {
        return CarPosition(position + 1)
    }
}
