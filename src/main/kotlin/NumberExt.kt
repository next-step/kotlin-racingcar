fun Int.isOdd() = this % 2 == 1

fun Double.isInt() = this % 1 == 0.0

fun Double.toPrintString(): String = if (isInt()) this.toInt().toString() else this.toString()

fun Double.isInvalid() = this.isInfinite() || this.isNaN()
