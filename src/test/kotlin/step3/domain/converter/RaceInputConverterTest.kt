package step3.domain.converter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceInputConverterTest : DescribeSpec({

    describe(name = "레이스 게임을 위한 정보 객체를 만들 때") {
        context(name = "숫자 문자열을 입력하면") {
            val expect = "123"

            val actual = RaceInputConverter.convertRaceGameInfo(
                carCountInputString = expect,
                roundInputString = expect,
            )

            it(name = "숫자가 객체 내 저장된다.") {
                actual.carCount shouldBe expect.toIntOrNull()
                actual.round shouldBe expect.toIntOrNull()
            }
        }

        context(name = "숫자가 아닌 문자열을 입력하면") {
            val text = "안녕하세요"

            it(name = "객체 생성이 되지 않고 IllegalArgumentException 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    RaceInputConverter.convertRaceGameInfo(
                        carCountInputString = text,
                        roundInputString = text,
                    )
                }
            }
        }
    }
})
