package app.revanced.patches.dcinside.misc

import app.revanced.patcher.extensions.InstructionExtensions.addInstruction
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patches.dcinside.misc.fingerprints.disableUpdateCheckFingerprint

@Suppress("unused")
val disableUpdateCheckPatch = bytecodePatch(
    name = "Disable update check",
    description = "Disables the app's update check.",
) {
    compatibleWith("com.dcinside.app"("5.1.7"))

    execute {
        val method = disableUpdateCheckFingerprint.method
        method.addInstruction(
            0,
            """
                return-void
            """.trimIndent()
        )
    }
}