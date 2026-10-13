package com.cutiepiaki.retrolog
import com.cutiepiaki.retrolog.MainActivity.PlatformLabel

object GameRepository {
    val games = listOf(
        Game(1, "Super Mario Land", "Platformer", PlatformLabel.GB),
        Game(2, "Tetris", "Puzzle", PlatformLabel.GB),
        Game(3, "Pokémon Red", "RPG", PlatformLabel.GB),
        Game(4, "The Legend of Zelda: Link's Awakening", "Action-Adventure", PlatformLabel.GB),
        Game(5, "Metroid II: Return of Samus", "Action-Adventure", PlatformLabel.GB),

        Game(6, "Pokémon Gold", "RPG", PlatformLabel.GBC),
        Game(7, "The Legend of Zelda: Oracle of Seasons", "Action-Adventure", PlatformLabel.GBC),
        Game(8, "Wario Land 3", "Platformer", PlatformLabel.GBC),
        Game(9, "Metal Gear Solid", "Stealth", PlatformLabel.GBC),
        Game(10, "Shantae", "Platformer", PlatformLabel.GBC),

        Game(11, "Metroid Fusion", "Action-Adventure", PlatformLabel.GBA),
        Game(12, "Golden Sun", "RPG", PlatformLabel.GBA),
        Game(13, "Advance Wars", "Strategy", PlatformLabel.GBA),
        Game(14, "Castlevania: Aria of Sorrow", "Action-Adventure", PlatformLabel.GBA),
        Game(15, "Pokémon Emerald", "RPG", PlatformLabel.GBA),

        Game(16, "Super Mario Bros.", "Platformer", PlatformLabel.NES),
        Game(17, "The Legend of Zelda", "Action-Adventure", PlatformLabel.NES),
        Game(18, "Mega Man 2", "Action", PlatformLabel.NES),
        Game(19, "Castlevania", "Action", PlatformLabel.NES),
        Game(20, "Final Fantasy", "RPG", PlatformLabel.NES),

        Game(21, "Super Mario World", "Platformer", PlatformLabel.SNES),
        Game(22, "Chrono Trigger", "RPG", PlatformLabel.SNES),
        Game(23, "Super Metroid", "Action-Adventure", PlatformLabel.SNES),
        Game(24, "The Legend of Zelda: A Link to the Past", "Action-Adventure", PlatformLabel.SNES),
        Game(25, "Donkey Kong Country", "Platformer", PlatformLabel.SNES),

        Game(26, "Sonic the Hedgehog 2", "Platformer", PlatformLabel.SEGAMD),
        Game(27, "Streets of Rage 2", "Beat 'em up", PlatformLabel.SEGAMD),

        Game(28, "Final Fantasy VII", "RPG", PlatformLabel.PS1),
        Game(29, "Metal Gear Solid", "Stealth", PlatformLabel.PS1),
        Game(30, "Resident Evil 2", "Survival Horror", PlatformLabel.PS1, isCompleted = true)
    )
}