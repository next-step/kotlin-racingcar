package nexstep.mission.calculator.io

object ConsoleInput : Input {

    override fun input(): List<String> {
        val input = readln()
        return InputParser.parse(input)
    }
}
