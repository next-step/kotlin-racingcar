package racingcar.car

fun randomListBy(range: IntRange, size: Int): List<Int> = List(size) { range.random() }
