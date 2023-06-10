package racinggame.domain.employee

import racinggame.domain.player.User

data class GameGuide(
    val users: List<User>,
    val gameRule: GameRule,
)
