package racingcar.util.extension

/**
 * 숫자가 양의 정수인지 확인하는 메서드
 */
fun Int.isPositive(): Boolean = this > 0

/**
 * 인자보다 같거나 큰지 확인하는 메서드
 */
fun Int.greaterThanOrEquals(value: Int): Boolean = this >= value
