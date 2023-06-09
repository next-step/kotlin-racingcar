package com.racing.step3.view

abstract class View<in T : Any> {
    fun exec(input: T, func: () -> Unit) {
        println(input)
        func()
    }
}
