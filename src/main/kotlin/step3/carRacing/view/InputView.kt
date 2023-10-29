package step3.carRacing.view

interface InputReader {
    fun readInput(): Int
}

class SystemInputReader : InputReader {
    override fun readInput(): Int {
        return readLine()!!.toInt()
    }
}
object InputView {

    fun getInputInfo(inputReader: InputReader): Pair<Int, Int> {
        println("경주할 자동차 대수를 입력하세요")
        val carCount = inputReader.readInput()
        println("시도할 회수는 몇회인가요?")
        val tryCount = inputReader.readInput()

        return Pair(carCount, tryCount)
    }
}
