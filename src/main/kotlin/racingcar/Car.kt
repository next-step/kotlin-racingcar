package racingcar

class Car {
    var position: Int = 0

    fun move(random: Int) {
        if (random >= FOREWORD_CRITERIA) this.position++
    }

    companion object {
        private const val FOREWORD_CRITERIA = 4
    }
}
