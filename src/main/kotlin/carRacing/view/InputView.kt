package carRacing.view

import carRacing.model.Car
import carRacing.model.CarGenerator


interface InputReader {
    fun readInput(): String
}

class SystemInputReader : InputReader {
    override fun readInput(): String {
        return readLine()!!
    }
}

object InputView {

    private fun getInput(inputReader: InputReader, inputString: String): String {
        println(inputString)
        return inputReader.readInput()
    }

    private fun getCarInfo(inputReader: InputReader): List<Car> =
        getInput(inputReader, "경주할 자동차의 이름을 입력하세요 (',' 구분 필요, 5자 이하)").split(",").map { it.trim() }.let { carNames ->
            carNames.forEach{Car.validateCarName(it)}
            carNames
        }.let {
            CarGenerator.generate(it)
        }

    private fun getTryCount(inputReader: InputReader): Int = getInput(inputReader, "시도할 회수는 몇회인가요?").toInt()

    fun getInputInfo(inputReader: InputReader): Pair<List<Car>, Int> =
        Pair(getCarInfo(inputReader), getTryCount(inputReader))
}
