package calculator.common

fun <T> Iterator<T>.hasNoNext(): Boolean = hasNext().not()
