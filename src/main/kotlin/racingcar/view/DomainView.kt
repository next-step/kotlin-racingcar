package racingcar.view

import racingcar.domain.Car
import racingcar.domain.RacingGameResult

private const val CAR_LOCATION_PATH_SYMBOL = "-"

fun Car.state(): String {
    return "$name : " + CAR_LOCATION_PATH_SYMBOL.repeat(location)
}

fun RacingGameResult.state(): String {
    val stringBuilder: StringBuilder = StringBuilder()

    for (car in cars) {
        stringBuilder.append(car.state())
        stringBuilder.append("\n")
    }

    return stringBuilder.toString()
}
