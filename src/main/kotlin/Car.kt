class Car(
    var moveCount: Int = 0,
) {
    fun move() {
        if ((0..9).random() >= 4) {
            moveCount = moveCount.plus(1)
        }
    }
}
