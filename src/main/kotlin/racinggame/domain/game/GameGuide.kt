package racinggame.domain.game

import racinggame.domain.player.User

data class GameGuide(
    val users: List<User>,
    val gameRule: GameRule,
)
