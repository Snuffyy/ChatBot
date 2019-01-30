package twitchbot.repository

class ChannelCommandRepositoryImpl : ChannelCommandRepository {

    private val channelCommands = mapOf(
            "#notsnuffy" to mapOf(
                    "!age" to "21"
            )
    )

    override fun getResponseForCommand(channel: String, command: String) = channelCommands[channel]?.get(command)
            ?: ""
}