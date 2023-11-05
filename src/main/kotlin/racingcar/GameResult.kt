package racingcar

class GameResult(val cars: List<Car>) {
    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()

        for (car in cars) {
            stringBuilder.append(car)
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
