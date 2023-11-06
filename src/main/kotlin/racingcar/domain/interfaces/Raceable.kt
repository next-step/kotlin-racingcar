package racingcar.domain.interfaces

/**
 * 자동차 경주 가능 인터페이스
 * */
interface Raceable {
    val name: String

    var position: Int

    fun move(condition: Int)
}