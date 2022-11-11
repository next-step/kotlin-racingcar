package racingcar

data class Car(
    val name: String,
    val position: Int = 0
) {
    fun move(foreword: Int): Car =
        if (foreword >= FOREWORD_CRITERIA) this.copy(position = this.position.inc())
        else this

    companion object {
        private const val FOREWORD_CRITERIA = 4
    }
}
