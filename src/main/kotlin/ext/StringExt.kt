package ext

import study.Utils

fun String.isNumeric(): Boolean = this.matches(Utils.NUMERIC_REGX)
