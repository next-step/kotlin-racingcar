package calculator.ext

import calculator.study.Utils

fun String.isNumeric(): Boolean = this.matches(Utils.NUMERIC_REGX)
