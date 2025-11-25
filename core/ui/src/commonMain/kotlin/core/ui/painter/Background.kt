package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource
import gnixpokedex.core.ui.generated.resources.Res
import gnixpokedex.core.ui.generated.resources.bug
import gnixpokedex.core.ui.generated.resources.dark
import gnixpokedex.core.ui.generated.resources.dragon
import gnixpokedex.core.ui.generated.resources.electric
import gnixpokedex.core.ui.generated.resources.fairy
import gnixpokedex.core.ui.generated.resources.fighting
import gnixpokedex.core.ui.generated.resources.fire
import gnixpokedex.core.ui.generated.resources.flying
import gnixpokedex.core.ui.generated.resources.ghost
import gnixpokedex.core.ui.generated.resources.grass
import gnixpokedex.core.ui.generated.resources.ground
import gnixpokedex.core.ui.generated.resources.ice
import gnixpokedex.core.ui.generated.resources.normal
import gnixpokedex.core.ui.generated.resources.poison
import gnixpokedex.core.ui.generated.resources.psychic
import gnixpokedex.core.ui.generated.resources.rock
import gnixpokedex.core.ui.generated.resources.steel
import gnixpokedex.core.ui.generated.resources.water

@Composable
private fun bugPainter(): Painter = painterResource(Res.drawable.bug)

@Composable
private fun darkPainter(): Painter = painterResource(Res.drawable.dark)

@Composable
private fun dragonPainter(): Painter = painterResource(Res.drawable.dragon)

@Composable
private fun electricPainter(): Painter = painterResource(Res.drawable.electric)

@Composable
private fun fairyPainter(): Painter = painterResource(Res.drawable.fairy)

@Composable
private fun fightingPainter(): Painter = painterResource(Res.drawable.fighting)

@Composable
private fun firePainter(): Painter = painterResource(Res.drawable.fire)

@Composable
private fun flyingPainter(): Painter = painterResource(Res.drawable.flying)

@Composable
private fun ghostPainter(): Painter = painterResource(Res.drawable.ghost)

@Composable
private fun grassPainter(): Painter = painterResource(Res.drawable.grass)

@Composable
private fun groundPainter(): Painter = painterResource(Res.drawable.ground)

@Composable
private fun icePainter(): Painter = painterResource(Res.drawable.ice)

@Composable
private fun normalPainter(): Painter = painterResource(Res.drawable.normal)

@Composable
private fun poisonPainter(): Painter = painterResource(Res.drawable.poison)

@Composable
private fun psychicPainter(): Painter = painterResource(Res.drawable.psychic)

@Composable
private fun rockPainter(): Painter = painterResource(Res.drawable.rock)

@Composable
private fun steelPainter(): Painter = painterResource(Res.drawable.steel)

@Composable
private fun waterPainter(): Painter = painterResource(Res.drawable.water)

@Composable
fun BackgroundsPainterMap(): HashMap<String, Painter> = hashMapOf(
    "bug" to _root_ide_package_.core.ui.core.ui.painter.bugPainter(),
    "dark" to _root_ide_package_.core.ui.core.ui.painter.darkPainter(),
    "dragon" to _root_ide_package_.core.ui.core.ui.painter.dragonPainter(),
    "electric" to _root_ide_package_.core.ui.core.ui.painter.electricPainter(),
    "fairy" to _root_ide_package_.core.ui.core.ui.painter.fairyPainter(),
    "fighting" to _root_ide_package_.core.ui.core.ui.painter.fightingPainter(),
    "fire" to _root_ide_package_.core.ui.core.ui.painter.firePainter(),
    "flying" to _root_ide_package_.core.ui.core.ui.painter.flyingPainter(),
    "ghost" to _root_ide_package_.core.ui.core.ui.painter.ghostPainter(),
    "grass" to _root_ide_package_.core.ui.core.ui.painter.grassPainter(),
    "ground" to _root_ide_package_.core.ui.core.ui.painter.groundPainter(),
    "ice" to _root_ide_package_.core.ui.core.ui.painter.icePainter(),
    "normal" to _root_ide_package_.core.ui.core.ui.painter.normalPainter(),
    "poison" to _root_ide_package_.core.ui.core.ui.painter.poisonPainter(),
    "psychic" to _root_ide_package_.core.ui.core.ui.painter.psychicPainter(),
    "rock" to _root_ide_package_.core.ui.core.ui.painter.rockPainter(),
    "steel" to _root_ide_package_.core.ui.core.ui.painter.steelPainter(),
    "water" to _root_ide_package_.core.ui.core.ui.painter.waterPainter(),
)
