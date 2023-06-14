package racinggame.domain.player

import racinggame.domain.car.CarName

data class User(
    val id: UserUniqueId,
    val carName: CarName,
    val ordinal: Int,
)
