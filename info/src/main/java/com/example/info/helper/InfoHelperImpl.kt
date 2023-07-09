package com.example.info.helper

import com.example.base.logger.Logger
import javax.inject.Inject

class InfoHelperImpl @Inject constructor(
    private val logger: Logger
): InfoHelper {
    override fun dumpInfo(message: String) {
        logger.log("InfoHelper - $message")
    }
}