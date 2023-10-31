package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlayersTest : StringSpec({

    "플레이어가 3명일 때, 플레이어의 이름은 'pobi', 'crong', 'honux'이다." {
        val players = Players("pobi,crong,honux")
        players.players[0].name shouldBe CarName("pobi")
        players.players[1].name shouldBe CarName("crong")
        players.players[2].name shouldBe CarName("honux")
    }

    "플레이어가 4명일 때, 플레이어의 이름은 'pobi', 'crong', 'honux', 'jk'이다." {
        val players = Players("pobi,crong,honux,jk")
        players.players[0].name shouldBe CarName("pobi")
        players.players[1].name shouldBe CarName("crong")
        players.players[2].name shouldBe CarName("honux")
        players.players[3].name shouldBe CarName("jk")
    }

    "우승자 확인" {
        val players = Players(listOf(Car("pobi", 1), Car("crong", 2), Car("honux", 3)))
        players.winners shouldBe listOf(Car("honux", 3))
    }

    "공동 우승자 확인" {
        val players = Players(listOf(Car("pobi", 1), Car("crong", 2), Car("honux", 2)))
        players.winners shouldBe listOf(Car("crong", 2), Car("honux", 2))
    }
})
