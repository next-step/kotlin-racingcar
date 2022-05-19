package racingcar.domain

class Car(var position: Int = 0) {
    var histories: MutableList<CarHistory> = mutableListOf()
        private set

    init {
        histories.add(CarHistory(position, false))
    }

    fun move(condition: Int) {
        if (condition in 4..9) {
            position++
        }
        histories.add(CarHistory(position, true))
    }
}

class CarHistory(var position: Int, val isChange: Boolean)
