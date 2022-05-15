package study.step3

class Moving {
    fun isMovable(): Boolean {
        return (0..9).random() >= 4
    }
}
