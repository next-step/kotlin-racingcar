package step2.calculator

fun Double.isNotZero(): Boolean = this != 0.0
fun Double.hasNoRemainder(): Boolean = this % 1 == 0.0

fun Int.overThan(target: Int): Boolean = this >= target
