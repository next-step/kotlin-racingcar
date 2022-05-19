package step3

class Car {
    fun moveOrStop(position: Int): String {
        return if (position >= STANDARD_FOR_CAR_CAN_MOVE) MOVE else STOP
    }

    companion object {
        private const val STANDARD_FOR_CAR_CAN_MOVE = 4

        private const val MOVE = "-"
        private const val STOP = ""
    }
}
