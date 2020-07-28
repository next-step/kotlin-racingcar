import java.lang.IllegalArgumentException

class InputView {

    fun carCountInput(): Int {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        if (carCount <= 0) {
            throw IllegalArgumentException("자동차 대수는 최소 1대 이상 필요합니다.input:$carCount")
        }
        return carCount
    }

    fun playCountInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val playCount = readLine()!!.toInt()
        if (playCount <= 0) {
            throw IllegalArgumentException("시도 횟수는  최소 1번 이상 필요합니다. input:$playCount")
        }
        return playCount
    }
}
