package mwvdev.quake.models;

public class PlayerState
{

    private static final int MAX_STATS = 16;
    private static final int MAX_PERSISTENT = 16;
    private static final int MAX_POWERUPS = 16;
    private static final int MAX_WEAPONS = 16;

    private static final int MAX_PS_EVENTS = 2;

    private Integer commandTime;
    private Integer pmType;
    private Integer bobCycle;
    private Integer pmFlags;
    private Integer pmTime;

    private Float[] origin = new Float[3];
    private Float[] velocity = new Float[3];
    private Integer weaponTime;
    private Integer gravity;
    private Integer speed;
    private Integer[] deltaAngles = new Integer[3];

    private Integer groundEntityNum;

    private Integer legsTimer;
    private Integer legsAnim;

    private Integer torsoTimer;
    private Integer torsoAnim;

    private Integer movementDir;

    private Float[] grapplePoint = new Float[3];

    private Integer eFlags;

    private Integer eventSequence;
    private Integer[] events = new Integer[MAX_PS_EVENTS];
    private Integer[] eventParms = new Integer[MAX_PS_EVENTS];

    private Integer externalEvent;
    private Integer externalEventParm;
    private Integer externalEventTime;

    private Integer clientNum;
    private Integer weapon;
    private Integer weaponstate;

    private Float[] viewAngles = new Float[3];
    private Integer viewHeight;

    private Integer damageEvent;
    private Integer damageYaw;
    private Integer damagePitch;
    private Integer damageCount;

    private Integer[] stats = new Integer[MAX_STATS];
    private Integer[] persistent = new Integer[MAX_PERSISTENT];
    private Integer[] powerups = new Integer[MAX_POWERUPS];
    private Integer[] ammo = new Integer[MAX_WEAPONS];

    private Integer generic1;
    private Integer loopSound;
    private Integer jumppadEntity;

    private Integer ping;
    private Integer pMoveFrameCount;
    private Integer jumppadFrame;
    private Integer entityEventSequence;

    public Integer getCommandTime()
    {
        return commandTime;
    }

    public void setCommandTime( Integer commandTime )
    {
        this.commandTime = commandTime;
    }

    public Integer getPmType()
    {
        return pmType;
    }

    public void setPmType( Integer pmType )
    {
        this.pmType = pmType;
    }

    public Integer getBobCycle()
    {
        return bobCycle;
    }

    public void setBobCycle( Integer bobCycle )
    {
        this.bobCycle = bobCycle;
    }

    public Integer getPmFlags()
    {
        return pmFlags;
    }

    public void setPmFlags( Integer pmFlags )
    {
        this.pmFlags = pmFlags;
    }

    public Integer getPmTime()
    {
        return pmTime;
    }

    public void setPmTime( Integer pmTime )
    {
        this.pmTime = pmTime;
    }

    public Float[] getOrigin()
    {
        return origin;
    }

    public void setOrigin( Float[] origin )
    {
        this.origin = origin;
    }

    public Float[] getVelocity()
    {
        return velocity;
    }

    public void setVelocity( Float[] velocity )
    {
        this.velocity = velocity;
    }

    public Integer getWeaponTime()
    {
        return weaponTime;
    }

    public void setWeaponTime( Integer weaponTime )
    {
        this.weaponTime = weaponTime;
    }

    public Integer getGravity()
    {
        return gravity;
    }

    public void setGravity( Integer gravity )
    {
        this.gravity = gravity;
    }

    public Integer getSpeed()
    {
        return speed;
    }

    public void setSpeed( Integer speed )
    {
        this.speed = speed;
    }

    public Integer[] getDeltaAngles()
    {
        return deltaAngles;
    }

    public void setDeltaAngles( Integer[] deltaAngles )
    {
        this.deltaAngles = deltaAngles;
    }

    public Integer getGroundEntityNum()
    {
        return groundEntityNum;
    }

    public void setGroundEntityNum( Integer groundEntityNum )
    {
        this.groundEntityNum = groundEntityNum;
    }

    public Integer getLegsTimer()
    {
        return legsTimer;
    }

    public void setLegsTimer( Integer legsTimer )
    {
        this.legsTimer = legsTimer;
    }

    public Integer getLegsAnim()
    {
        return legsAnim;
    }

    public void setLegsAnim( Integer legsAnim )
    {
        this.legsAnim = legsAnim;
    }

    public Integer getTorsoTimer()
    {
        return torsoTimer;
    }

    public void setTorsoTimer( Integer torsoTimer )
    {
        this.torsoTimer = torsoTimer;
    }

    public Integer getTorsoAnim()
    {
        return torsoAnim;
    }

    public void setTorsoAnim( Integer torsoAnim )
    {
        this.torsoAnim = torsoAnim;
    }

    public Integer getMovementDir()
    {
        return movementDir;
    }

    public void setMovementDir( Integer movementDir )
    {
        this.movementDir = movementDir;
    }

    public Float[] getGrapplePoint()
    {
        return grapplePoint;
    }

    public void setGrapplePoint( Float[] grapplePoint )
    {
        this.grapplePoint = grapplePoint;
    }

    public Integer geteFlags()
    {
        return eFlags;
    }

    public void seteFlags( Integer eFlags )
    {
        this.eFlags = eFlags;
    }

    public Integer getEventSequence()
    {
        return eventSequence;
    }

    public void setEventSequence( Integer eventSequence )
    {
        this.eventSequence = eventSequence;
    }

    public Integer[] getEvents()
    {
        return events;
    }

    public void setEvents( Integer[] events )
    {
        this.events = events;
    }

    public Integer[] getEventParms()
    {
        return eventParms;
    }

    public void setEventParms( Integer[] eventParms )
    {
        this.eventParms = eventParms;
    }

    public Integer getExternalEvent()
    {
        return externalEvent;
    }

    public void setExternalEvent( Integer externalEvent )
    {
        this.externalEvent = externalEvent;
    }

    public Integer getExternalEventParm()
    {
        return externalEventParm;
    }

    public void setExternalEventParm( Integer externalEventParm )
    {
        this.externalEventParm = externalEventParm;
    }

    public Integer getExternalEventTime()
    {
        return externalEventTime;
    }

    public void setExternalEventTime( Integer externalEventTime )
    {
        this.externalEventTime = externalEventTime;
    }

    public Integer getClientNum()
    {
        return clientNum;
    }

    public void setClientNum( Integer clientNum )
    {
        this.clientNum = clientNum;
    }

    public Integer getWeapon()
    {
        return weapon;
    }

    public void setWeapon( Integer weapon )
    {
        this.weapon = weapon;
    }

    public Integer getWeaponstate()
    {
        return weaponstate;
    }

    public void setWeaponstate( Integer weaponstate )
    {
        this.weaponstate = weaponstate;
    }

    public Float[] getViewAngles()
    {
        return viewAngles;
    }

    public void setViewAngles( Float[] viewAngles )
    {
        this.viewAngles = viewAngles;
    }

    public Integer getViewHeight()
    {
        return viewHeight;
    }

    public void setViewHeight( Integer viewHeight )
    {
        this.viewHeight = viewHeight;
    }

    public Integer getDamageEvent()
    {
        return damageEvent;
    }

    public void setDamageEvent( Integer damageEvent )
    {
        this.damageEvent = damageEvent;
    }

    public Integer getDamageYaw()
    {
        return damageYaw;
    }

    public void setDamageYaw( Integer damageYaw )
    {
        this.damageYaw = damageYaw;
    }

    public Integer getDamagePitch()
    {
        return damagePitch;
    }

    public void setDamagePitch( Integer damagePitch )
    {
        this.damagePitch = damagePitch;
    }

    public Integer getDamageCount()
    {
        return damageCount;
    }

    public void setDamageCount( Integer damageCount )
    {
        this.damageCount = damageCount;
    }

    public Integer[] getStats()
    {
        return stats;
    }

    public void setStats( Integer[] stats )
    {
        this.stats = stats;
    }

    public Integer[] getPersistent()
    {
        return persistent;
    }

    public void setPersistent( Integer[] persistent )
    {
        this.persistent = persistent;
    }

    public Integer[] getPowerups()
    {
        return powerups;
    }

    public void setPowerups( Integer[] powerups )
    {
        this.powerups = powerups;
    }

    public Integer[] getAmmo()
    {
        return ammo;
    }

    public void setAmmo( Integer[] ammo )
    {
        this.ammo = ammo;
    }

    public Integer getGeneric1()
    {
        return generic1;
    }

    public void setGeneric1( Integer generic1 )
    {
        this.generic1 = generic1;
    }

    public Integer getLoopSound()
    {
        return loopSound;
    }

    public void setLoopSound( Integer loopSound )
    {
        this.loopSound = loopSound;
    }

    public Integer getJumppadEntity()
    {
        return jumppadEntity;
    }

    public void setJumppadEntity( Integer jumppadEntity )
    {
        this.jumppadEntity = jumppadEntity;
    }

    public Integer getPing()
    {
        return ping;
    }

    public void setPing( Integer ping )
    {
        this.ping = ping;
    }

    public Integer getpMoveFrameCount()
    {
        return pMoveFrameCount;
    }

    public void setpMoveFrameCount( Integer pMoveFrameCount )
    {
        this.pMoveFrameCount = pMoveFrameCount;
    }

    public Integer getJumppadFrame()
    {
        return jumppadFrame;
    }

    public void setJumppadFrame( Integer jumppadFrame )
    {
        this.jumppadFrame = jumppadFrame;
    }

    public Integer getEntityEventSequence()
    {
        return entityEventSequence;
    }

    public void setEntityEventSequence( Integer entityEventSequence )
    {
        this.entityEventSequence = entityEventSequence;
    }

}
