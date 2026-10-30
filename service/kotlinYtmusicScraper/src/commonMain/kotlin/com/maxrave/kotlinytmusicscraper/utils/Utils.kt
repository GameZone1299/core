package com.maxrave.kotlinytmusicscraper.utils

import com.maxrave.kotlinytmusicscraper.models.response.AudioData
import com.maxrave.logger.Logger
import kotlinx.serialization.json.Json
import kotlin.io.encoding.Base64

fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> eachByte.toString(16).padStart(2, '0') }

fun sha1(str: String): String = ""

fun parseCookieString(cookie: String): Map<String, String> =
    cookie
        .split("; ")
        .filter { it.isNotEmpty() }
        .associate {
            val (key, value) = it.split("=")
            key to value
        }

fun String.parseTime(): Int? {
    try {
        val parts =
            if (this.contains(":")) split(":").map { it.toInt() } else split(".").map { it.toInt() }
        if (parts.size == 2) {
            return parts[0] * 60 + parts[1]
        }
        if (parts.size == 3) {
            return parts[0] * 3600 + parts[1] * 60 + parts[2]
        }
    } catch (e: Exception) {
        return null
    }
    return null
}

fun generateNetscapeCookies(
    cookies: Map<String, String>,
    domain: String = ".example.com",
    path: String = "/",
    secure: Boolean = false,
    httpOnly: Boolean = false,
    expirationTimeSeconds: Long = 0L,
): String {
    val header =
        "# Netscape HTTP Cookie File\n" +
            "# This is a generated file! Do not edit.\n\n"
    return header +
        cookies.entries.joinToString("\n") { (name, value) ->
            "$domain\tTRUE\t$path\t${if (secure) "TRUE" else "FALSE"}\t$expirationTimeSeconds\t$name\t$value"
        }
}
