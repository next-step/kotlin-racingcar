package step3.racing

class Car(var distance: Long = 0) {
  private fun move() {
    distance += 1
  }

  private fun isMoved() = RandomGenerator.getInt(0, 9) > 4

  fun run(isMoved: Boolean = isMoved()) {
    if (isMoved) move()
    ResultView.showDistance(distance)
  }
}
