package step3.component

class InputComponent(
    val label: String,
    onCommand: (value: String) -> Unit = {}
) : Component {
    var onCommand = onCommand
        private set

    override fun render() {
        println(this.label)
        val commandValue = readLine()!!
        this.onCommand(commandValue)
    }

    fun addCommandListener(onCommand: (String) -> Unit) {
        this.onCommand = onCommand
    }
}
