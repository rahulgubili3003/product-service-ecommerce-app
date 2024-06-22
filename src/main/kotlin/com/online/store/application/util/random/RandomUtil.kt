package com.online.store.application.util.random

import java.util.Random

object RandomUtil {
    fun generateProductId(): String {
        val rnd: Random = Random()
        val number: Int = rnd.nextInt(999999)
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number)
    }
}