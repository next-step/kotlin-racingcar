package study.racingcar.domain

class Moving {
    fun isMovable(): Boolean {
        return (0..9).random() >= 4
    }
}
