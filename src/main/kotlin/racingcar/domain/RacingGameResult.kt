package racingcar.domain

class RacingGameResult(val cars: List<Car>) {

    fun getWinners(): List<Car> {
        val maxLocation = cars.maxBy { it.location }.location
        return cars.filter { it.location == maxLocation }
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()

        for (car in cars) {
            stringBuilder.append(car)
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
