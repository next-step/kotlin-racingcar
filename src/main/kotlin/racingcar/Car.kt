package racingcar

class Car(
    var position: Int = 0
) {
    fun move(moveCount: Int): Int {
        if (moveCount in 4..9) {
            return ++position
        }
        if (moveCount in 0..3) {
            return position
        }
        throw IllegalArgumentException("자동차는 0~9의 값만 입력받을 수 있다.")
    }
}
