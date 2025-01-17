package at.raven.ravenAddons.features

import at.raven.ravenAddons.config.ravenAddonsConfig
import at.raven.ravenAddons.loadmodule.LoadModule
import at.raven.ravenAddons.ravenAddons
import at.raven.ravenAddons.utils.ChatUtils
import at.raven.ravenAddons.utils.RegexUtils.matchMatcher
import at.raven.ravenAddons.utils.StringUtils.removeColors
import kotlinx.coroutines.delay
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@LoadModule
object DropAlert {
    private val rngPattern =
        "^(?<type>PRAY TO RNGESUS|INSANE|CRAZY RARE|VERY RARE|RARE|UNCOMMON|PET) DROP! (?<drop>.+)\$".toPattern()

    @SubscribeEvent
    fun onChat(event: ClientChatReceivedEvent) {
        if (!ravenAddonsConfig.dropAlert || ravenAddonsConfig.dropAlertUserName.isEmpty()) return

        rngPattern.matchMatcher(event.message.formattedText.removeColors()) {
            val type = group("type")
            val drop = group("drop")

            ChatUtils.debug("dropAlert triggered: $type DROP! $drop")

            ravenAddons.launchCoroutine {
                delay(500)

                ChatUtils.sendMessage("/msg ${ravenAddonsConfig.dropAlertUserName} [RA] $type DROP! $drop")
            }
        }
    }
}