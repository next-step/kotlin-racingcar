package step3.racingcar

class Car(
    val movements: List<Boolean> = emptyList()
) {
    companion object {
        fun withMovements(moveCount: Int): Car {
            return Car(carMovements(moveCount))
        }

        private fun carMovements(moveCount: Int) = List(moveCount) { isCarMove() }

        private fun isCarMove() = (0..9).random() >= GO_NUMBER

        private const val GO_NUMBER = 4
    }
}
