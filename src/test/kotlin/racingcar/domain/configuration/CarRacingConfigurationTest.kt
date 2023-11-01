package racingcar.domain.configuration

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarRacingConfigurationTest : FunSpec({
    context("자동차 경주 게임 설정 정보 생성") {
        test("자동차 경주 게임 설정 정보가 생성된다") {
            val carNames = listOf("name1", "name2")
            val roundCount = 2

            val result = CarRacingConfiguration.of(roundCount, carNames)

            result.cars.size shouldBe carNames.size
            result.cars.forEachIndexed { index, car ->
                car.name.value shouldBe carNames[index]
                car.position shouldBe 0
            }
            result.roundCount.value shouldBe roundCount
        }

        test("자동차 이름으로 빈 리스트가 들어오면 설정 정보 생성에 실패한다") {
            val carNames = emptyList<String>()

            shouldThrow<IllegalArgumentException> {
                CarRacingConfiguration.of(1, carNames)
            }
        }

        test("자동차 이름 규칙에 맞지 않는 이름이 들어오면 설정 정보 생성에 실패한다") {
            val wrongCarName = "abcdef"

            shouldThrow<IllegalArgumentException> {
                CarRacingConfiguration.of(1, listOf(wrongCarName))
            }
        }

        test("라운드 횟수에 맞지 않는 숫자가 들어오면 설정 정보 생성에 실패한다") {
            val wrongRoundCount = 0

            shouldThrow<IllegalArgumentException> {
                CarRacingConfiguration.of(wrongRoundCount, listOf("test"))
            }
        }
    }
})
