package view

class InputView {
    fun input(): InputCommand {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names : List<String> = readln().split(",")
        val trial : Int = readln().toIntOrNull() ?: throw IllegalArgumentException()
        return InputCommand(names, trial)
    }
}

data class InputCommand(var names : List<String>, val trial : Int)