package carracing.view

class InputView {
    fun inputCount(inputType: InputType): Int {
        println(inputType.question)
        return readln().toInt()
    }
}
