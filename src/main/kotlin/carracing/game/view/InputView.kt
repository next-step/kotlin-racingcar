package carracing.game.view

class InputView {
    fun inquireCarsAmount(): String? {
        println("How many cars are in the race?")
        return readlnOrNull()
    }

    fun inquireRoundsAmount(): String? {
        println("How many rounds will be played?")
        return readlnOrNull()
    }
}
