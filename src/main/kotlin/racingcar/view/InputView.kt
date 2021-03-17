package racingcar.view

import racingcar.util.Message.Companion.DELIMITERS_COMMA
import racingcar.util.Message.Companion.NOTICE_INPUT_CAR_NAME
import racingcar.util.Message.Companion.NOTICE_INPUT_TRY_COUNT
import racingcar.util.extension.checkMaxLength
import racingcar.util.extension.splitToInputName
import racingcar.util.extension.toInt

object InputView {
    fun getCountOfGame(): Int {
        println(NOTICE_INPUT_TRY_COUNT)
        return readLine().toInt()
    }

    fun getInfoOfCars(): List<String> {
        println(NOTICE_INPUT_CAR_NAME)
        val splitName = getSplitName()
        splitName.checkMaxLength()
        return splitName
    }

    private fun getSplitName() = readLine().splitToInputName(DELIMITERS_COMMA)
}
