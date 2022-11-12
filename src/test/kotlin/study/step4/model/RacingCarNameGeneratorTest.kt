package study.step4.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat
import study.step4.model.RacingCarNameGenerator.convertCarNamesList

class RacingCarNameGeneratorTest : StringSpec({

    "자동차 이름의 마지막에 쉽포(,)로 입력하고, 이름 검증을 하면, 마지막은 빈값으로 포함하고 리스트를 반환한다" {
        listOf("popd," to 2, "popo , " to 2, "  po, poodd  , " to 3)
            .forAll { (carNames, size) ->
                val racingGame = convertCarNamesList(racingCarNames = carNames)

                assertThat(racingGame.size).isEqualTo(size)
                assertThat(racingGame.last()).isEmpty()
            }
    }
})
