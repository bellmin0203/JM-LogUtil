package com.jm.logutil


import java.util.regex.Matcher
import java.util.regex.Pattern

object CallStackUtil {
    private val ANONYMOUS_CLASS: Pattern = Pattern.compile("(\\$\\d+)+$")

    private fun getClassName(element: StackTraceElement): String {
        var tag = element.className
        val m: Matcher = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)

        return tag
    }

    fun makeCallStackTrace(): String {
        val element = Throwable().stackTrace[2]
        return "[${getClassName(element)}/${element.methodName}:${element.lineNumber}] >> "
    }
}