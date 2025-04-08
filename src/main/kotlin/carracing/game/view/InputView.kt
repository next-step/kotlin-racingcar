package carracing.game.view

class InputView {
    fun inquireCarsNames(): String? {
        println("Input names of each car")
        return readlnOrNull()
    }

    fun inquireRoundsAmount(): String? {
        println("How many rounds will be played?")
        return readlnOrNull()
    }
}
