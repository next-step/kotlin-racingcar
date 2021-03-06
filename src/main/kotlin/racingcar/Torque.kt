package racingcar

/**
 * [Engine]이 발생시키는 돌림힘.
 *
 * 차를 움직여 차의 위치를 변경시킨다.
 */
enum class Torque(val value: Int) {
    STOP(0),
    MOVE(1)
    ;
}
