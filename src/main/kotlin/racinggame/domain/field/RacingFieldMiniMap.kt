package racinggame.domain.field

import racinggame.domain.player.UserUniqueId

interface RacingFieldMiniMap {

    val racingFieldMap: Map<UserUniqueId, Field>
}
