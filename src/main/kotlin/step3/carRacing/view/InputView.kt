package step3.carRacing.view

class InputView() {

    companion object{
        fun getInputInfo(): Pair<Int, Int> {
            println("경주할 자동차 대수를 입력하세요")
            val carCount = readLine()!!.toInt()
            println("시도할 회수는 몇회인가요?")
            val tryCount = readLine()!!.toInt()

            return Pair(carCount, tryCount)
        }
    }

}
