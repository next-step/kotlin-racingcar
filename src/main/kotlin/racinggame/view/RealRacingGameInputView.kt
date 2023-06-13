package racinggame.view

class RealRacingGameInputView : RacingGameInputView {
    override fun readLine(): String {
        return readlnOrNull().orEmpty()
    }
}
