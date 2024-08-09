package com.jm.logutil

import android.content.Context
import android.os.Environment
import android.util.Log
import timber.log.Timber
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FileDebugTree(private val context: Context) : Timber.DebugTree() {

    companion object {
        private const val LOG_DIR = "Logs"
        private const val LOG_NAME_DATE_FORMAT = "yyyyMMdd"
        private const val LOG_EXTENSION = ".log"
        private const val LOG_TIMESTAMP_FORMAT = "MM-dd HH:mm:ss.SSS"

        private const val SECOND = 1000L
        private const val MINUTE = 60L * SECOND
        private const val HOUR = 60L * MINUTE
        private const val DAY = 24L * HOUR

        private var file: File? = null
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)

        val fileNameTimeStamp =
            SimpleDateFormat(LOG_NAME_DATE_FORMAT, Locale.getDefault()).format(Date())
        val logTimeStamp =
            SimpleDateFormat(LOG_TIMESTAMP_FORMAT, Locale.getDefault()).format(Date())

        var logLevel = "V"
        when (priority) {
            Log.DEBUG -> logLevel = "D"
            Log.INFO -> logLevel = "I"
            Log.WARN -> logLevel = "W"
            Log.ERROR -> logLevel = "E"
            Log.ASSERT -> logLevel = "A"
        }

        val fileName = fileNameTimeStamp + LOG_EXTENSION

        if (file == null || file?.name != fileName) {
            file = createFile(context, fileName)
        }

        if (file != null) {
            val fw = FileWriter(file, true)
            val bwr = BufferedWriter(fw)

            bwr.append(logTimeStamp)
                .append("/")
                .append(" ")
                .append(logLevel)
                .append("/")
                .append(tag)
                .append(":")
                .append(" ")
                .append(message)
                .append("\r\n")
            bwr.flush()
            bwr.close()
            fw.close()
        }

    }

    private fun createFile(context: Context, fileName: String): File? {
        try {
            val root = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), LOG_DIR)

            if (!root.exists()) {
                if (root.mkdirs()) {
                    Timber.tag("FileDebugTree").d("Directory created: %s", root.absolutePath)
                    return File(root, fileName)
                } else {
                    Timber.tag("FileDebugTree")
                        .e("Failed to create directory: %s", root.absolutePath)
                    return null
                }
            } else {
                Timber.tag("FileDebugTree").e("Already exists directory: %s", root.absolutePath)
                return null
            }
        } catch (e: NullPointerException) {
            return null
        } catch (e: SecurityException) {
            return null
        }
    }
}