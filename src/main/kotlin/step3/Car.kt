package step3

class Car(
    private val mover: Mover
) {
    var distance: Int = 0
        private set

    fun race() {
        if (mover.canMove()) {
            distance++
        }
    }
}
