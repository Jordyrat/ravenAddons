package at.raven.ravenAddons.config

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

object ravenAddonsConfig : Vigilant(File("./config/ravenAddons.toml")) {

    @Property(
        type = PropertyType.SWITCH,
        name = "DROP Alerts",
        description = "Message a user about your RARE DROPS.",
        category = "SkyBlock"
    )
    var dropAlert = false

    @Property(
        type = PropertyType.TEXT,
        name = "DROP Alerts Username",
        description = "Choose a username for your RARE DROPS.",
        category = "SkyBlock"
    )
    var dropAlertUserName = ""

    @Property(
        type = PropertyType.SWITCH,
        name = "Enable Debug Messages",
        description = "This allows the user to see debug messages.",
        category = "Developer"
    )
    var debugMessages = false

    @Property(
        type = PropertyType.TEXT,
        name = "/ratesttitle Title",
        description = "Sets the title for the test title.",
        category = "Developer"
    )
    var developerTitle = ""

    @Property(
        type = PropertyType.TEXT,
        name = "/ratesttitle SubTitle",
        description = "Sets the subTitle for the test title.",
        category = "Developer"
    )
    var developerSubTitle = ""

    init {
        initialize()

        val clazz = javaClass

        addDependency(clazz.getDeclaredField("dropAlertUserName"), clazz.getDeclaredField("dropAlert"))
    }
}