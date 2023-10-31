package car_racing.ui

class InputView() {
    companion object {
        fun readlines(): List<Int> {
            println("자동차 대수는 몇 대인가요?")
            val carNumber = readLine()!!.toInt()
            println("시도할 회수는 몇 회인가요?")
            val tryNumber = readLine()!!.toInt()

            return listOf(carNumber, tryNumber)
        }
    }
}
