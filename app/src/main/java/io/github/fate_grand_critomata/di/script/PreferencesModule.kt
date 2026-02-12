package io.github.fate_grand_critomata.di.script

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import io.github.fate_grand_critomata.scripts.models.AutoSkillCommand
import io.github.fate_grand_critomata.scripts.models.CardPriorityPerWave
import io.github.fate_grand_critomata.scripts.models.ServantPriorityPerWave
import io.github.fate_grand_critomata.scripts.models.SpamConfigPerTeamSlot
import io.github.fate_grand_critomata.scripts.prefs.IBattleConfig
import io.github.fate_grand_critomata.scripts.prefs.IPreferences
import io.github.fate_grand_critomata.scripts.prefs.ISupportPreferences
import io.github.fate_grand_critomata.scripts.prefs.ISupportPreferencesCommon
import io.github.lib_automata.dagger.ScriptScope

@Module
@InstallIn(ScriptComponent::class)
class PreferencesModule {
    @ScriptScope
    @Provides
    fun provideBattleConfig(prefs: IPreferences): IBattleConfig =
        prefs.selectedBattleConfig

    @ScriptScope
    @Provides
    fun provideSupportPrefs(battleConfig: IBattleConfig): ISupportPreferences =
        battleConfig.support

    @ScriptScope
    @Provides
    fun provideCommonSupportPrefs(prefs: IPreferences): ISupportPreferencesCommon =
        prefs.support

    @ScriptScope
    @Provides
    fun provideSpamConfig(battleConfig: IBattleConfig): SpamConfigPerTeamSlot =
        SpamConfigPerTeamSlot(battleConfig.spam)

    @ScriptScope
    @Provides
    fun provideSkillCommand(battleConfig: IBattleConfig): AutoSkillCommand =
        AutoSkillCommand.parse(battleConfig.skillCommand)

    @ScriptScope
    @Provides
    fun provideCardPriority(battleConfig: IBattleConfig): CardPriorityPerWave =
        battleConfig.cardPriority

    @ScriptScope
    @Provides
    fun provideServantPriority(battleConfig: IBattleConfig): ServantPriorityPerWave? =
        if (battleConfig.useServantPriority) battleConfig.servantPriority else null
}