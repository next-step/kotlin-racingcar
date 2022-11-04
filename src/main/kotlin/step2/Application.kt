package step2

import com.dajeong.step2.StringCalculator
import step2.operator.*

class Application {
    private val stopCommand = "0"
    private val stringCalculator = StringCalculator(OperatorSelector())

    fun run() {
        println(PROGRAM_INFO)
        while (true) {
            println(BEGIN_GUIDE)
            val runCommand = readLine()
            if (stopCommand == runCommand) {
                break;
            }
            println(INPUT_GUIDE)
            val calculateValues = readLine()
            val answer = stringCalculator.calculate(calculateValues)
            print(RESULT_GUIDE)
            println("${answer}\n")
        }
        println(CLOSE_GUIDE)
        return
    }
}