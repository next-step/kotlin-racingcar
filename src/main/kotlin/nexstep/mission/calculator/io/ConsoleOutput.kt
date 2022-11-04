package nexstep.mission.calculator.io

object ConsoleOutput : Output {

    override fun output(result: Int) {
        println("답 : $result")
    }
}
