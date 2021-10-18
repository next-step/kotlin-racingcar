package step3

object Random {
    fun canMoveFoward(): Boolean {
        return (0..9).random() >= 4
    }
}
