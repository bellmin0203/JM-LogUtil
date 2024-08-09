package com.jm.logutil

sealed class LogMode {
    data object NONE: LogMode()
    data object LOGCAT: LogMode()
    data object FILE: LogMode()
    data object ALL: LogMode()
}