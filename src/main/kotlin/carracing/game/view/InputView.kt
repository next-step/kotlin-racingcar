package carracing.game.view

import carracing.game.domain.data.Car

class InputView {
    fun inquireCarsNames(): String? {
        println("Input names of each car (length <= ${Car.NAME_MAX_LENGTH} and separate with ,)")
        return readlnOrNull()
    }

    fun inquireRoundsAmount(): String? {
        println("How many rounds will be played?")
        return readlnOrNull()
    }
}
