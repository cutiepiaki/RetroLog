package com.cutiepiaki.retrolog

object GameRepository {
    val games = listOf(
        Game(1, "Super Mario Land", "Platformer", MainActivity.PlatformLabel.GB),
        Game(2, "Tetris", "Puzzle", MainActivity.PlatformLabel.GB),
        Game(3, "Pokémon Red", "RPG", MainActivity.PlatformLabel.GB),
        Game(4, "The Legend of Zelda: Link's Awakening", "Action-Adventure", MainActivity.PlatformLabel.GB),
        Game(5, "Metroid II: Return of Samus", "Action-Adventure", MainActivity.PlatformLabel.GB),

        Game(6, "Pokémon Gold", "RPG", MainActivity.PlatformLabel.GBC),
        Game(7, "The Legend of Zelda: Oracle of Seasons", "Action-Adventure", MainActivity.PlatformLabel.GBC),
        Game(8, "Wario Land 3", "Platformer", MainActivity.PlatformLabel.GBC),
        Game(9, "Metal Gear Solid", "Stealth", MainActivity.PlatformLabel.GBC),
        Game(10, "Shantae", "Platformer", MainActivity.PlatformLabel.GBC),

        Game(11, "Metroid Fusion", "Action-Adventure", MainActivity.PlatformLabel.GBA),
        Game(12, "Golden Sun", "RPG", MainActivity.PlatformLabel.GBA),
        Game(13, "Advance Wars", "Strategy", MainActivity.PlatformLabel.GBA),
        Game(14, "Castlevania: Aria of Sorrow", "Action-Adventure", MainActivity.PlatformLabel.GBA),
        Game(15, "Pokémon Emerald", "RPG", MainActivity.PlatformLabel.GBA),

        Game(16, "Super Mario Bros.", "Platformer", MainActivity.PlatformLabel.NES),
        Game(17, "The Legend of Zelda", "Action-Adventure", MainActivity.PlatformLabel.NES),
        Game(18, "Mega Man 2", "Action", MainActivity.PlatformLabel.NES),
        Game(19, "Castlevania", "Action", MainActivity.PlatformLabel.NES),
        Game(20, "Final Fantasy", "RPG", MainActivity.PlatformLabel.NES),

        Game(21, "Super Mario World", "Platformer", MainActivity.PlatformLabel.SNES),
        Game(22, "Chrono Trigger", "RPG", MainActivity.PlatformLabel.SNES),
        Game(23, "Super Metroid", "Action-Adventure", MainActivity.PlatformLabel.SNES),
        Game(24, "The Legend of Zelda: A Link to the Past", "Action-Adventure", MainActivity.PlatformLabel.SNES),
        Game(25, "Donkey Kong Country", "Platformer", MainActivity.PlatformLabel.SNES),

        Game(26, "Sonic the Hedgehog 2", "Platformer", MainActivity.PlatformLabel.SEGAMD),
        Game(27, "Streets of Rage 2", "Beat 'em up", MainActivity.PlatformLabel.SEGAMD),

        Game(28, "Final Fantasy VII", "RPG", MainActivity.PlatformLabel.PS1),
        Game(29, "Metal Gear Solid", "Stealth", MainActivity.PlatformLabel.PS1),
        Game(30, "Resident Evil 2", "Survival Horror", MainActivity.PlatformLabel.PS1, isCompleted = true)
    )
}