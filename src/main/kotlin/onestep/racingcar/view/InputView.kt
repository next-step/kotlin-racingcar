package onestep.racingcar.view

class InputView(
    private val getNameOfCarsInput: () -> String? = { readLine() },
    private val getNumberOfTryInput: () -> String? = { readLine() }
) {

    private fun getNameOfCars(): List<String> {
        return try {
            showQuestion(INPUT_NAME_OF_CAR, getNameOfCarsInput).split(SEPARATOR)
        } catch (e: Exception) {
            println(INPUT_TRY_AGAIN + e.localizedMessage)
            getNameOfCars()
        }
    }

    private fun getNumberOfTry(): Int {
        return try {
            val input = showQuestion(INPUT_NUMBER_OF_TRY, getNumberOfTryInput).toIntOrNull()
                ?: throw IllegalArgumentException("Wrong Input (Not Integer)")
            require(input > 0) { "Input Only Positive integer ( input = $input)" }
            input
        } catch (e: Exception) {
            println(INPUT_TRY_AGAIN + e.localizedMessage)
            getNumberOfTry()
        }
    }

    private fun showQuestion(question: String, input: () -> String?): String {
        println(question)
        return input() ?: throw IllegalArgumentException("Wrong Input( null )")
    }

    fun getInputs() = Pair(getNameOfCars(), getNumberOfTry())

    companion object {
        private const val SEPARATOR = ","
        private const val INPUT_NAME_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표($SEPARATOR)를 기준으로 구분)."
        private const val INPUT_NUMBER_OF_TRY = "자동차의 전진을 시도할 수를 입력하세요."
        private const val INPUT_TRY_AGAIN = "잘못 입력 하셨습니다."
    }
}
