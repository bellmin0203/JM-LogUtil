package com.jm.logutil

import android.content.Context
import timber.log.Timber

class LogUtil private constructor() {
    companion object {

        @Volatile
        private var INSTANCE: LogUtil? = null
        private var logMode: LogMode = LogMode.LOGCAT
        private var tag: String? = null

        fun getInstance() = INSTANCE ?: synchronized(this) {
            INSTANCE ?: LogUtil().apply { INSTANCE = this }
        }

        fun init(context: Context, logMode: LogMode = LogMode.LOGCAT, tag: String) {
            this.logMode = logMode
            this.tag = tag

            when (this.logMode) {
                LogMode.ALL -> Timber.plant(Timber.DebugTree(), FileDebugTree(context))
                LogMode.FILE -> Timber.plant(FileDebugTree(context))
                LogMode.LOGCAT -> Timber.plant(Timber.DebugTree())
                LogMode.NONE -> Timber.tag(tag).d("Log disabled")
            }
        }

        /** Log a verbose message with optional format args. */
        fun v(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.v("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).v("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a verbose exception and a message with optional format args. */
        fun v(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.v(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).v(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a verbose exception. */
        fun v(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.v(t)
            } else {
                Timber.tag(tag!!).v(t)
            }
        }

        /** Log a debug message with optional format args. */
        fun d(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.d("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).d("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a debug exception and a message with optional format args. */
        fun d(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.d(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).d(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a debug exception. */
        fun d(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.d(t)
            } else {
                Timber.tag(tag!!).d(t)
            }
        }

        /** Log an info message with optional format args. */
        fun i(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.i("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).i("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an info exception and a message with optional format args. */
        fun i(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.i(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).i(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an info exception. */
        fun i(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.i(t)
            } else {
                Timber.tag(tag!!).i(t)
            }
        }

        /** Log a warning message with optional format args. */
        fun w(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.w("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).w("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a warning exception and a message with optional format args. */
        fun w(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.w(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).w(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log a warning exception. */
        fun w(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.w(t)
            } else {
                Timber.tag(tag!!).w(t)
            }
        }

        /** Log an error message with optional format args. */
        fun e(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.e("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).e("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an error exception and a message with optional format args. */
        fun e(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.e(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).e(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an error exception. */
        fun e(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.e(t)
            } else {
                Timber.tag(tag!!).e(t)
            }
        }

        /** Log an assert message with optional format args. */
        fun wtf(message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.wtf("${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).wtf("${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an assert exception and a message with optional format args. */
        fun wtf(t: Throwable?, message: String?, vararg args: Any?) {
            if (tag.isNullOrEmpty()) {
                Timber.wtf(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            } else {
                Timber.tag(tag!!).wtf(t, "${CallStackUtil.makeCallStackTrace()}$message", args)
            }
        }

        /** Log an assert exception. */
        fun wtf(t: Throwable?) {
            if (tag.isNullOrEmpty()) {
                Timber.wtf(t)
            } else {
                Timber.tag(tag!!).wtf(t)
            }
        }

    }
}