package onestep.racingcar.view

class InputView(
    private val getInput: () -> String? = { readLine() }
) {
    companion object {
        private const val INPUT_NUMBER_OF_CAR = "레이싱 경기를 진행할 자동차의 수를 입력하세요."
        private const val INPUT_NUMBER_OF_TRY = "자동차의 전진을 시도할 수를 입력하세요."
    }

    private fun inputNumberOfCars() = showQuestion(INPUT_NUMBER_OF_CAR)

    private fun inputNumberOfTry() = showQuestion(INPUT_NUMBER_OF_TRY)

    private fun showQuestion(question: String): Int {
        println(question)
        val questionAnswer = validationInput(getInput())
        if (questionAnswer <= 0) {
            throw IllegalArgumentException("Input Only Positive integer ( input = $questionAnswer)")
        }
        return questionAnswer
    }

    private fun validationInput(input: String?) =
        input?.toIntOrNull() ?: throw IllegalArgumentException("Wrong Input($input)")

    fun showInput() = Pair(inputNumberOfCars(), inputNumberOfTry())
}
