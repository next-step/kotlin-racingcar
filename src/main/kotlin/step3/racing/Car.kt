package step3.racing

class Car(val distance: Long = 0) {
  fun move() = Car(distance + 1)
}
