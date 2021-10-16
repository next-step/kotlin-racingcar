package racingcar

/**
 * 자동차가 전진할지에 대한 여부를 판단하기 위한 인터페이스
 *
 * 만약 자동차에 상태를 기반으로 조건을 결정한다면 파라미터로 같이 넘겨받으면 가능할 듯
 */
fun interface RacingCarForwardCondition {

    fun canForward(): Boolean
}
