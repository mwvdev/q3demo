

import mwvdev.quake.constants.PlayerMoveType
import mwvdev.quake.constants.WeaponType
import mwvdev.quake.loaders.DemoLoader
import mwvdev.quake.models.Demo
import mwvdev.quake.models.Message
import spock.lang.Specification

import java.nio.channels.Channel
import java.nio.channels.Channels

class DemoLoaderTest extends Specification {

    DemoLoader demoLoader = new DemoLoader()

    def "DemoLoader should load demo"() {
        InputStream inputStream = Class.getResourceAsStream( "/evil-v-Spart1e-sinister-21618.dm_73" )
        Channel channel = Channels.newChannel( inputStream )

        Demo demo = demoLoader.loadDemo( channel )
        Message message1 = demo.messages.get( 0 )
        Message message2 = demo.messages.get( 1 )

        expect:
        demo.messages.size == 19281

        message1.sequence == 81141
        message1.acknowledge == 62
        message1.gameState.sequence == 589
        message1.gameState.configStrings.get( 3 ) == "Sinister"
        message1.gameState.configStrings.get( 659 ) == "SPART^41^7E"
        message1.gameState.configStrings.get( 660 ) == "^48PLAY^7 evil"
        message1.gameState.entityStates.size == 66
        message1.gameState.entityStates.get( 0 ).number == 72
        message1.gameState.entityStates.get( 0 ).position.base[0] == 308
        message1.gameState.entityStates.get( 0 ).position.base[1] == -160
        message1.gameState.entityStates.get( 0 ).position.base[2] == -7
        message1.gameState.entityStates.get( 0 ).entityType == 2
        message1.gameState.entityStates.get( 0 ).groundEntityNum == 1022
        message1.gameState.entityStates.get( 0 ).getOrigin()[0] == 308
        message1.gameState.entityStates.get( 0 ).getOrigin()[1] == -160
        message1.gameState.entityStates.get( 0 ).getOrigin()[2] == -7
        message1.gameState.entityStates.get( 0 ).getModelIndex() == 8

        message2.sequence == 81144
        message2.acknowledge == 62
        message2.serverCommands.size == 1
        message2.snapshot.serverTime == 19800
        message2.snapshot.flags == 5
        message2.snapshot.playerState.commandTime == 19740
        message2.snapshot.playerState.origin[0] == 1272
        message2.snapshot.playerState.origin[1] == 488
        message2.snapshot.playerState.viewAngles[1].toString() == "-179.93958"
        message2.snapshot.playerState.viewAngles[0].toString() == "-0.010986328"
        message2.snapshot.playerState.origin[2].toString() == "88.19"
        message2.snapshot.playerState.eventSequence == 1
        message2.snapshot.playerState.torsoAnim == 11
        message2.snapshot.playerState.events[0] == 82
        message2.snapshot.playerState.legsAnim == 22
        message2.snapshot.playerState.pmFlags == 4100
        message2.snapshot.playerState.groundEntityNum == 1022
        message2.snapshot.playerState.eFlags == 16384
        message2.snapshot.playerState.gravity == 800
        message2.snapshot.playerState.speed == 320
        message2.snapshot.playerState.deltaAngles[1] == 32769
        message2.snapshot.playerState.viewHeight == 26
        message2.snapshot.playerState.pmType == PlayerMoveType.PM_SPECTATOR
        message2.snapshot.playerState.weapon == WeaponType.WP_MACHINEGUN

        message2.snapshot.playerState.stats == [115, null, null, 510, null, null, 65, 100, null, null, null, null, null, null, null, null]
        message2.snapshot.playerState.persistent == [null, null, 16384, null, 1, null, null, null, null, null, null, null, null, null, null, null]
        message2.snapshot.playerState.ammo == [null, 65535, 150, 25, 25, 25, 150, 25, 150, null, 65535, null, null, null, null, null]
    }

}