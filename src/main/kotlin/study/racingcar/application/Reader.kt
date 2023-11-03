package study.racingcar.application

// TODO-review : RacingGame 을 테스트 하기 위해, Reader 의 read 기능을 2 가지로 나눴습니다.
interface Reader {
    fun readString(): String?

    fun readInt(): String?
}
