package racingcar.domain

data class Car(val distance: Distance = Distance()) {

    fun move(i: Int): Car {
        if (i >= 4) {
            return copy(distance = distance.sum(Distance(1)))
        }
        return this
    }
}
