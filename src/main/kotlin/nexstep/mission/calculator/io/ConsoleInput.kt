package nexstep.mission.calculator.io

import java.util.Scanner

object ConsoleInput : Input {

    override fun input(): List<String> {
        val scanner = Scanner(System.`in`)
        val input = scanner.nextLine()
        return InputParser.parse(input)
    }
}
