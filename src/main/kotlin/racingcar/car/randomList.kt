package racingcar.car

fun randomListBy(pool: IntRange, size: Int): List<Int> = List(size) { pool.random() }
