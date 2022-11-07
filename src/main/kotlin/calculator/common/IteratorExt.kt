package calculator.common

fun <T> Iterator<T>.hasNoNext(): Boolean = hasNext().not()
fun ListIterator<String>.nextToInt() = this.next().toInt()
fun ListIterator<String>.nextToOperator() = this.next().toOperator()
