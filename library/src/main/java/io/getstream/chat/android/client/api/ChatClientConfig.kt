package io.getstream.chat.android.client.api

import io.getstream.chat.android.client.logger.ChatLogger
import io.getstream.chat.android.client.notifications.options.ChatNotificationConfig
import io.getstream.chat.android.client.token.TokenManager
import io.getstream.chat.android.client.token.TokenManagerImpl


internal class ChatClientConfig(
    val apiKey: String,
    var httpUrl: String,
    var cdnHttpUrl: String,
    var wssUrl: String,
    var baseTimeout: Long,
    var cdnTimeout: Long,
    val loggerConfig: ChatLogger.Config,
    val notificationsConfig: ChatNotificationConfig,
    val tokenManager: TokenManager = TokenManagerImpl()
) {

    var isAnonymous: Boolean = false
}