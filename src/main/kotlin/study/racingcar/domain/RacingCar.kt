package study.racingcar.domain

/**
 * 기능
 *    - 식별할 수 있는 id 와 위치값 상태를 갖는다.
 *    - 앞뒤로 이동해서 위치값 상태를 수정하는 함수를 제공한다.
 *    - 초기 위치보다 뒤로 이동하지는 않는다.
 * */
class RacingCar(
    val id: String,
    var position: Int
) {
    fun moveForward() {
        position += 1
    }

    fun moveBackward() {
        if (position <= 1) return
        position -= 1
    }
}
