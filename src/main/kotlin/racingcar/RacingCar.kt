package racingcar

class RacingCar {
    // TODO 06. distance는 String이 아닌 Int로 -> 궁극적으론 거리 이동과 이동한 거리에 대한 출력을 분리
    var distance: String = ""

    fun run(randomNum: Int) {
        if (isRunnable(randomNum)) {
            distance = "$distance-"
        }
    }

    fun isRunnable(randomNum: Int) = randomNum in 4..9
}
