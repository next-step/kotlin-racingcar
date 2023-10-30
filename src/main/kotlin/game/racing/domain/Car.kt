package game.racing.domain

class Car {
    var position = MIN_POSITION

    fun move() {
        if (isMovePossible(getRandomValue())) {
            position++
        }
    }

//    TODO private 함수로 만들고 싶다.. 현재는 테스트를 위해 public으로 두었다..
    fun isMovePossible(value: Int): Boolean {
        return value >= MIN_MOVE_THRESHOLD
    }

//    TODO private 함수로 만들고 싶다.. 현재는 테스트를 위해 public으로 두었다..
    fun getRandomValue(): Int {
        return (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
        private const val MIN_POSITION = 1
        private const val MIN_MOVE_THRESHOLD = 4
    }
}
