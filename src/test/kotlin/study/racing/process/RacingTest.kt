package study.racing.process

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "aasdf", "a,bbbbbbbb", ",33f", "afsf,55555", " , ", "  a  1 , b    5 "
        ]
    )
    fun `자동차 이름이 4글자이하가 아니거나 공백인 경우 에러를 반환한다`(
        carNames: String
    ) {
        assertThrows<IllegalArgumentException> {
            val racing = Racing()
            racing.playRacing(carNames, 1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -11, -111])
    fun `라운드수 입력시 1이상의 정수가 아닌 경우 에러를 반환한다`(
        roundCount: Int
    ) {
        assertThrows<IllegalArgumentException> {
            val racing = Racing()
            racing.playRacing("a,b,c,d", roundCount)
        }
    }
}
