package carracing.view

class InputView {
    fun inputCount(inputType: InputType): Int {
        println(inputType.question)
        return readln().toInt()
    }

    fun inputString(inputType: InputType): List<String> {
        println(inputType.question)
        return readln().split(",")
    }
}
