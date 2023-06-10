package com.racing.step3.util

import kotlin.random.Random

fun randomMoveCarStrategy(): () -> Int = { Random.nextInt(10) }

fun fixedMoveCareStrategy(): () -> Int = { 9 }
