package racinggame.domain.judge

import racinggame.domain.player.User

data class EvaluationResult(
    val winners: List<User>,
)
