package racingcar

class Car(
    id: Int,
    currentPosition: Int = 0,
) {
    var currentPosition: Int = currentPosition
        private set

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.isPossibleMove()) {
            this.currentPosition += moveStrategy.getDistance()
        }
    }
}

// class Car(position: Int = 0) {
//     var position: Int = position
//         private set
//
//     fun move(foreword: Int) {
//         if (foreword >= FOREWORD_CRITERIA) this.position++
//     }
//
//     companion object {
//         private const val FOREWORD_CRITERIA = 4
//     }
// }
