package com.maxrave.kotlinytmusicscraper.extension

import kotlin.random.Random

fun String.sha256(): String {
    return this
}

fun randomString(length: Int): String {
    val chars = "0123456789abcdef"
    return (1..length)
        .map { chars[Random.nextInt(chars.length)] }
        .joinToString("")
}

fun String.verifyYouTubePlaylistId(): String = if (startsWith("VL")) this else "VL$this"

fun stripMarkdown(markdown: String): String = markdown
