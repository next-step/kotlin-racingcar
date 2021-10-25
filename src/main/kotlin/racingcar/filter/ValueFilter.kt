package racingcar.filter

import racingcar.exception.BizException
import racingcar.exception.message.input.InputErrorMessage

object ValueFilter : Filter {

    private fun Any.toInt(): Int = this.toString().toIntOrNull() ?: throw BizException.InputException(InputErrorMessage.NOT_NUMBER)

    private fun valueRangeCheck(value: Int) = require(value > 0) { BizException.InputException(InputErrorMessage.OUT_OF_RANGE) }

    override fun verify(value: Any): Int {
        val returnValue: Int = value.toInt()
        valueRangeCheck(returnValue)
        return returnValue
    }
}
