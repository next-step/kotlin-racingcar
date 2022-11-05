package stringcalculator.application

import stringcalculator.operator.OperatorRegister
import stringcalculator.operator.OperatorSelector

class Application {
    private val stringCalculator: StringCalculator = StringCalculator(
        OperatorSelector(OperatorRegister.operators)
    )

    companion object {
        private const val STOP_COMMAND = "0"
    }

    fun run() {
        println(GuideScript.PROGRAM_INFO)
        while (true) {
            println(GuideScript.BEGIN_GUIDE)
            val runCommand = readln()
            if (STOP_COMMAND == runCommand) {
                break
            }
            println(GuideScript.INPUT_GUIDE)
            val calculateValues = readln()
            val answer = stringCalculator.calculate(calculateValues)
            print(GuideScript.RESULT_GUIDE)
            println("${answer}\n")
        }
        println(GuideScript.CLOSE_GUIDE)
        return
    }
}
