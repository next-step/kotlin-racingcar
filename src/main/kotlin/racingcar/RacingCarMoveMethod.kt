package racingcar

/**
 * 자동차가 전진할지에 대한 여부를 판단하기 위한 인터페이스
 */
fun interface RacingCarMoveMethod {

    fun isForward(): Boolean
}
