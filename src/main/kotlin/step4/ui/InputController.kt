package step4.ui

object InputController {
    private const val DELIMITER_OF_CAR_NAMES = ","

    fun input(): InputValue {
        val nameOfCars =
            printAndReadString("경주할 자동차 이름을 입력하세요. (이름은 $DELIMITER_OF_CAR_NAMES 기준으로 구분)").split(DELIMITER_OF_CAR_NAMES)
        val numberOfTrials = printAndReadInt("시도할 회수는 몇 회 인가요?")

        return InputValue(nameOfCars, numberOfTrials)
    }

    private fun printAndReadString(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    private fun printAndReadInt(message: String): Int {
        println(message)
        return readlnOrNull()?.toInt() ?: 0
    }
}

class InputValue(
    val nameOfCars: List<String>,
    val numberOfTrials: Int,
)
