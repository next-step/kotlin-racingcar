package step3.domain

class CarPosition(val position: Int) {
    fun move(): CarPosition {
        return CarPosition(position + 1)
    }
}
