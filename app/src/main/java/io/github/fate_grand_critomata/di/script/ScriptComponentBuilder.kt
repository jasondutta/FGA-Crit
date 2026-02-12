package io.github.fate_grand_critomata.di.script

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import io.github.lib_automata.ScreenshotService

@DefineComponent.Builder
interface ScriptComponentBuilder {
    fun screenshotService(@BindsInstance screenshotService: ScreenshotService): ScriptComponentBuilder
    fun build(): ScriptComponent
}