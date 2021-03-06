package io.getstream.chat.android.client.api

import io.getstream.chat.android.client.api.models.*
import retrofit2.Call
import retrofit2.http.*


interface RetrofitApi {

    // region channels

    @GET("/channels")
    fun queryChannels(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") clientID: String,
        @Query("payload") payload: QueryChannelsRequest
    ): Call<QueryChannelsResponse>

    @POST("/channels/{type}/{id}/query")
    fun queryChannel(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") clientID: String,
        @Body request: QueryChannelRequest
    ): Call<ChannelResponse>

    @POST("/channels/{type}/query")
    fun queryChannel(
        @Path("type") channelType: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") clientID: String,
        @Body request: QueryChannelRequest
    ): Call<ChannelResponse>

    @POST("/channels/{type}/{id}")
    fun updateChannel(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: UpdateChannelRequest
    ): Call<ChannelResponse>

    @DELETE("/channels/{type}/{id}")
    fun deleteChannel(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String
    ): Call<ChannelResponse>

    @POST("/channels/{type}/{id}/stop-watching")
    @JvmSuppressWildcards // See issue: https://github.com/square/retrofit/issues/3275
    fun stopWatching(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: Map<Any, Any>
    ): Call<CompletableResponse>

    @POST("/channels/{type}/{id}")
    fun acceptInvite(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: AcceptInviteRequest
    ): Call<ChannelResponse>

    @POST("/channels/{type}/{id}")
    fun rejectInvite(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: RejectInviteRequest
    ): Call<ChannelResponse>

    @POST("/channels/{type}/{id}/hide")
    fun hideChannel(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: HideChannelRequest
    ): Call<CompletableResponse>

    @POST("/channels/{type}/{id}/show")
    @JvmSuppressWildcards // See issue: https://github.com/square/retrofit/issues/3275
    fun showChannel(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") clientID: String,
        @Body body: Map<Any, Any>
    ): Call<CompletableResponse>

    @POST("/channels/{type}/{id}/read")
    fun markRead(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body request: MarkReadRequest
    ): Call<EventResponse>

    @POST("/channels/read")
    fun markAllRead(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<EventResponse>

    @POST("/channels/{type}/{id}/event")
    fun sendEvent(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body request: SendEventRequest
    ): Call<EventResponse>

    // endregion

    //region users

    @POST("/users")
    fun updateUsers(
        @Query("connection_id") connectionId: String,
        @Body body: UpdateUsersRequest
    ): Call<UpdateUsersResponse>

    @POST("/guest")
    fun getGuestUser(
        @Query("api_key") apiKey: String,
        @Body body: GuestUserRequest
    ): Call<TokenResponse>

    @GET("/users")
    fun queryUsers(
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Query("payload") payload: QueryUsersRequest
    ): Call<QueryUserListResponse>

    @POST("/channels/{type}/{id}")
    fun addMembers(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Body body: AddMembersRequest
    ): Call<ChannelResponse>

    @POST("/channels/{type}/{id}")
    fun removeMembers(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Body body: RemoveMembersRequest
    ): Call<ChannelResponse>

    @POST("/moderation/mute")
    fun muteUser(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body body: MuteUserRequest
    ): Call<MuteUserResponse>

    @POST("/moderation/unmute")
    fun unMuteUser(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body body: MuteUserRequest
    ): Call<MuteUserResponse>

    @POST("/moderation/flag")
    fun flag(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body body: Map<String, String>
    ): Call<FlagResponse>

    @POST("/moderation/ban")
    fun banUser(
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Body body: BanUserRequest
    ): Call<CompletableResponse>

    @DELETE("/moderation/ban")
    fun unBanUser(
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Query("target_user_id") targetUserId: String,
        @Query("type") channelType: String,
        @Query("id") channelId: String
    ): Call<CompletableResponse>

    //endregion

    //region messages

    @POST("/channels/{type}/{id}/message")
    @JvmSuppressWildcards // See issue: https://github.com/square/retrofit/issues/3275
    fun sendMessage(
        @Path("type") channelType: String,
        @Path("id") channelId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body message: MessageRequest
    ): Call<MessageResponse>

    @POST("/messages/{id}")
    @JvmSuppressWildcards // See issue: https://github.com/square/retrofit/issues/3275
    fun updateMessage(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body message: MessageRequest
    ): Call<MessageResponse>

    @GET("/messages/{id}")
    fun getMessage(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<MessageResponse>

    @POST("/messages/{id}/action")
    fun sendAction(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body request: SendActionRequest
    ): Call<MessageResponse>

    @DELETE("/messages/{id}")
    fun deleteMessage(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<MessageResponse>

    @POST("/messages/{id}/reaction")
    fun sendReaction(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body request: ReactionRequest
    ): Call<ReactionResponse>

    @DELETE("/messages/{id}/reaction/{type}")
    fun deleteReaction(
        @Path("id") messageId: String,
        @Path("type") reactionType: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<MessageResponse>

    @GET("/messages/{id}/reactions")
    fun getReactions(
        @Path("id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<GetReactionsResponse>

    @GET("/messages/{parent_id}/replies")
    fun getReplies(
        @Path("parent_id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Query("limit") limit: Int
    ): Call<GetRepliesResponse>

    @GET("/messages/{parent_id}/replies")
    fun getRepliesMore(
        @Path("parent_id") messageId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Query("limit") limit: Int,
        @Query("id_lt") firstId: String
    ): Call<GetRepliesResponse>

    //endregion

    //region search

    @GET("/search")
    fun searchMessages(
        @Query("api_key") apiKey: String,
        @Query("client_id") connectionId: String,
        @Query("payload") payload: SearchMessagesRequest
    ): Call<SearchMessagesResponse>

    //endregion

    // region Device
    @GET("/devices")
    fun getDevices(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<GetDevicesResponse>

    @POST("devices")
    fun addDevices(
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String,
        @Body request: AddDeviceRequest
    ): Call<CompletableResponse>

    @DELETE("/devices")
    fun deleteDevice(
        @Query("id") deviceId: String,
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("client_id") connectionId: String
    ): Call<CompletableResponse>

    // endregion
}
