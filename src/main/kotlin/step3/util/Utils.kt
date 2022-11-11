package step3.util

class Utils {
    companion object {
        const val RANDOM_NUMBER_START_INDEX = 0
        const val RANDOM_NUMBER_END_INDEX = 9

        fun generateRandomNumber(startNumber: Int, endNumber: Int): Int {
            require(startNumber < endNumber) { "시작 숫자는 종료 숫자보다 작아야 합니다." }
            return (startNumber..endNumber).random()
        }
    }
}
