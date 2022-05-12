package racingcar

open class Car {
    var position = 0
        protected set

    open fun move(movePoint: Int = (0..9).random()) {
        validateMovePoint(movePoint)

        if (movePoint >= 4) {
            position++
        }
    }

    private fun validateMovePoint(movePoint: Int) {
        if (movePoint > 9 || movePoint < 0) {
            throw IllegalArgumentException("0 ~ 9 사이의 movePoint 만 가능합니다.")
        }
    }
}