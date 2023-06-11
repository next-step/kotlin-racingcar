interface InputView {
    fun displayMessage()
}

class CarCountMessage : InputView {
    override fun displayMessage() {
        println("자동차 대수는 몇 대인가요?")
    }
}

class GameCountMessage : InputView {
    override fun displayMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }
}

enum class InputType {
    CAR_COUNT,
    GAME_COUNT
}
