package racing

class CarRacing {
    fun input() {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = readLine()!!.toInt()

        // 실행
    }

    private fun go(): Boolean = (0..9).random() >= 4
}
