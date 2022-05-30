package racingcar.car

private const val DATUM_POINT = 4
private const val FORWARD_POINT = 1
private const val STOP_POINT = 0

fun drivingPointBy(drivingForce: Int) = if (drivingForce >= DATUM_POINT) FORWARD_POINT else STOP_POINT
