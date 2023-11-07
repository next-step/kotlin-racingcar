package racingcar.domain.interfaces

/**
 * 자동차 전진 인터페이스
 * */
interface Moveable {
    fun move(condition: Int)
    fun isMove(condition: Int): Boolean
}
