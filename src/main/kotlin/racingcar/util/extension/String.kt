package racingcar.util.extension

import racingcar.util.Message
import racingcar.util.Message.Companion.MAX_LENGTH_NAME
import racingcar.util.Message.Companion.NOTICE_CANNOT_CAST_TO_INT
import racingcar.util.Message.Companion.NOTICE_NOT_BLANK
import racingcar.util.Message.Companion.NOTICE_NOT_NULL

fun String?.toInt(): Int {
    return requireNotNull(this?.toIntOrNull(), { this + NOTICE_CANNOT_CAST_TO_INT })
}

fun String.splitNotBlank(delimiter: String): List<String> {
    require(isNotBlank()) { NOTICE_NOT_BLANK }
    return split(delimiter)
}

fun String?.splitToInputName(delimiter: String): List<String> {
    return requireNotNull(this?.splitNotBlank(delimiter), { NOTICE_NOT_NULL })
}

fun List<String>.checkMaxLength() {
    require(
        filter { name ->
            name.length > MAX_LENGTH_NAME
        }.none()
    ) { Message.NOTICE_NOT_MAXLENGTH_NAME }
}
