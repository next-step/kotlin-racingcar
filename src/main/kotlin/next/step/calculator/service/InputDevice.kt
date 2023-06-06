package next.step.calculator.service

import next.step.calculator.domain.ActionCommand

object InputDevice {
    private const val SELECT_ACTION = "원하는 동작을 선택해주세요."
    private const val INVALID_CMD_MSG = "잘못된 명령어 입니다."
    private const val ENTER_EXPRS = "수식을 입력하세요"
    fun readActionCommand(): ActionCommand {
        return try {
            print("$SELECT_ACTION (${ActionCommand.descAll()}) ")
            ActionCommand.valueOf(readln())
        } catch (e: Exception) {
            println(INVALID_CMD_MSG)
            readActionCommand()
        }
    }

    fun readCalculationCommand(): String {
        print("$ENTER_EXPRS: ")
        return readln()
    }
}
