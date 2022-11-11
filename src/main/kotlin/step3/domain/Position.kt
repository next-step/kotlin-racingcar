package step3.domain

data class Position(var position: Int) {
    fun move() {
        position++
    }
}
