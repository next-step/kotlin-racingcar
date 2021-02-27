package step2.util.extension

import step2.util.Const.Companion.NOTICE_NOT_BLANK
import step2.util.Const.Companion.NOTICE_NOT_NULL
import step2.util.Const.Companion.NOTICE_NOT_OPERAND_SYMBOL

fun String.splitNotBlank(delimiter: String): List<String> {
    require(isNotBlank()) { NOTICE_NOT_BLANK }
    return split(delimiter)
}

fun String?.splitToCalculate(delimiter: String): List<String> {
    if (this?.length == 1) toDouble(NOTICE_NOT_OPERAND_SYMBOL)
    return requireNotNull(this?.splitNotBlank(delimiter), { NOTICE_NOT_NULL })
}

fun String.toDouble(message: String): Double {
    return requireNotNull(toDoubleOrNull(), { plus(message) })
}
