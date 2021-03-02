package racingcar.util.extension

import racingcar.util.Message.Companion.NOTICE_CANNOT_CAST_TO_INT

fun String?.toInt(): Int {
    return requireNotNull(this?.toIntOrNull(), { this + NOTICE_CANNOT_CAST_TO_INT })
}
