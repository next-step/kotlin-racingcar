package calculator.ext

import calculator.study.Utils

fun String.isNumeric(): Boolean = matches(Utils.NUMERIC_REGX)
