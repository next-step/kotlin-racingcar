package racingcar.domain

class Car(val id: Int) {
    var distance:Int = 1

    fun drive() {
        distance++
    }
}