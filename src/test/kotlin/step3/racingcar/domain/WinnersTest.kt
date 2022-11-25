package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step3.racingcar.fixture.CarFixtureGenerator

internal class WinnersTest : BehaviorSpec({
    given("경주를 완료한 자동차 객체 목록이 주어지고") {
        val 첫_번째_차량 = CarFixtureGenerator.경주를_완료한_차량_생성("첫 번째 차량", 1, 1, 1, 4, 4)
        val 두_번째_차량 = CarFixtureGenerator.경주를_완료한_차량_생성("두 번째 차량", 1, 1, 4, 4, 4)
        val 세_번째_차량 = CarFixtureGenerator.경주를_완료한_차량_생성("세 번째 차량", 4, 4, 4, 1, 1)

        `when`("우승자 객체를 생성하면") {
            val joinerCars = Cars.of(listOf(첫_번째_차량, 두_번째_차량, 세_번째_차량))
            val given = Winners.of(joinerCars)
            then("우승한 차량들의 이름을 반환한다.") {
                given.names shouldBe "${두_번째_차량.name}, ${세_번째_차량.name}"
            }
        }
    }
})
