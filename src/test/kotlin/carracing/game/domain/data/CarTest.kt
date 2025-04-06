
package carracing.game.domain.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest :
    StringSpec({
        "when randomNumber > 3 should increment position" {
            listOf(4, 5).forEach { randomNumber ->
                Car().apply { move(randomNumber) }.position shouldBe 1
            }
        }

        "when randomNumber < 4 should do nothing" {
            listOf(-1, 3).forEach { randomNumber ->
                Car().apply { move(randomNumber) }.position shouldBe 0
            }
        }
    })
