package calculator

class UserInput(private val inputStrategy: InputStrategy) {

    fun operate(): String {
        askQuestion()
        return validate(inputStrategy.enter())
    }

    private fun askQuestion() {
        println("입력해주세요")
    }

    private fun validate(input: String?): String {
        require(!input.isNullOrEmpty())
        return input
    }
}
