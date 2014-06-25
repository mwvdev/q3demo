import mwvdev.quake.constants.PlayerMoveType
import mwvdev.quake.constants.WeaponType
import mwvdev.quake.exceptions.LoaderException
import mwvdev.quake.loaders.DemoLoader
import mwvdev.quake.models.DeltaEntityState
import mwvdev.quake.models.Demo
import mwvdev.quake.models.EntityState
import mwvdev.quake.models.Message
import spock.lang.Specification

import java.nio.channels.Channel
import java.nio.channels.Channels

class DemoLoaderTest extends Specification {

    DemoLoader demoLoader = new DemoLoader()

    def "should load demo"() {
        InputStream inputStream = Class.getResourceAsStream( "/evil-v-Spart1e-sinister-21618.dm_73" )
        Channel channel = Channels.newChannel( inputStream )

        Demo demo = demoLoader.loadDemo( channel )
        Message message1 = demo.messages.get( 0 )
        Message message2 = demo.messages.get( 1 )
        Message message3 = demo.messages.get( 573 )

        expect:
        demo.messages.size == 19281

        message1.sequence == 81141
        message1.acknowledge == 62
        message1.gameState.sequence == 589
        message1.gameState.configStrings.get( 3 ) == "Sinister"
        message1.gameState.configStrings.get( 659 ) == "SPART^41^7E"
        message1.gameState.configStrings.get( 660 ) == "^48PLAY^7 evil"
        message1.gameState.entityStates.size == 66
        message1.gameState.entityStates.get( 0 ) instanceof DeltaEntityState
        DeltaEntityState deltaEntityState = message1.gameState.entityStates.get( 0 )
        deltaEntityState.number == 72
        deltaEntityState.position.base[0] == 308
        deltaEntityState.position.base[1] == -160
        deltaEntityState.position.base[2] == -7
        deltaEntityState.entityType == 2
        deltaEntityState.groundEntityNum == 1022
        deltaEntityState.getOrigin()[0] == 308
        deltaEntityState.getOrigin()[1] == -160
        deltaEntityState.getOrigin()[2] == -7
        deltaEntityState.getModelIndex() == 8

        message2.sequence == 81144
        message2.acknowledge == 62
        message2.serverCommands.size == 1
        message2.snapshot.serverTime == 19800
        message2.snapshot.flags == 5
        message2.snapshot.playerState.commandTime == 19740
        message2.snapshot.playerState.origin[0] == 1272f
        message2.snapshot.playerState.origin[1] == 488f
        message2.snapshot.playerState.viewAngles[1] == -179.93958f
        message2.snapshot.playerState.viewAngles[0] == -0.010986328f
        message2.snapshot.playerState.origin[2] == 88.19f
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

        message3.sequence == 81716
        message3.acknowledge == 63
        message3.snapshot.serverTime == 34875
        message3.snapshot.flags == 0
        message3.snapshot.areaMask == [-2]
        message3.snapshot.playerState.commandTime == 34810
        message3.snapshot.playerState.origin[0] == 336.49506f
        message3.snapshot.playerState.origin[1] == -207.10805f
        message3.snapshot.playerState.bobCycle == 2
        message3.snapshot.playerState.velocity[0] == 258.06137f
        message3.snapshot.playerState.velocity[1] == 72.98913f
        message3.snapshot.playerState.weaponTime == 120
        message3.snapshot.playerState.origin[2] == 0.32596123f
        message3.snapshot.playerState.velocity[2] == 0.70607257f
        message3.snapshot.playerState.legsTimer == 126
        message3.snapshot.playerState.pmTime == 246
        message3.snapshot.playerState.eventSequence == 15
        message3.snapshot.playerState.events[0] == 7
        message3.snapshot.playerState.legsAnim == -109
        message3.snapshot.playerState.pmFlags == 4128
        message3.snapshot.playerState.groundEntityNum == 1022
        message3.snapshot.playerState.damageYaw == -1
        message3.snapshot.playerState.damagePitch == -1

        message3.snapshot.playerState.stats == [88, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
        message3.snapshot.playerState.persistent == [null, null, null, null, null, null, 1022, null, null, null, null, null, null, null, null, null]

        message3.snapshot.entityStates.get( 0 ) instanceof EntityState
        DeltaEntityState entityState = message3.snapshot.entityStates.get( 0 )
        entityState.number == 6
        entityState.position.base[0] == 955
        entityState.position.base[1] == 523
        entityState.position.delta[0] == 269
        entityState.position.delta[1] == -382
        entityState.position.base[2] == 123
        entityState.angle.base[1] == -48
        entityState.position.delta[2] == -138
    }

    def "should throw loading exception on truncated demo"() {
        InputStream inputStream = Class.getResourceAsStream( "/evil-v-Spart1e-sinister-21618-truncated.dm_73" )
        Channel channel = Channels.newChannel( inputStream )

        when:
        demoLoader.loadDemo( channel )

        then:
        thrown( LoaderException.class )
    }

}