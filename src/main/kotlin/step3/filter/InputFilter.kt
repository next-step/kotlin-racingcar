package step3.filter

import step3.exception.BizException
import step3.exception.message.input.InputErrorMessage

object InputFilter : Filter {

    override fun parameterFilter(any: Any) {
        if (any !is Int) throw BizException.InputException(InputErrorMessage.NOT_NUMBER)
    }
}
