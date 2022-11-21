package racingcar.view.ui

class Input(onCommand: (value: String) -> Unit = {}) : UI {
    var onCommand = onCommand
        private set

    fun addCommandListener(onCommand: (String) -> Unit) {
        this.onCommand = onCommand
    }

    override fun draw() {
        val commandValue = readLine()!!
        this.onCommand(commandValue)
    }
}
