package mwvdev.quake.models;

public class EntityState
{

    private Integer number;
    private Integer entityType;
    private Integer entityFlags;

    private Trajectory position = new Trajectory();
    private Trajectory angle = new Trajectory();

    private Integer time;
    private Integer time2;

    private Float[] origin = new Float[3];
    private Float[] origin2 = new Float[3];

    private Float[] angles = new Float[3];
    private Float[] angles2 = new Float[3];

    private Integer otherEntityNum;
    private Integer otherEntityNum2;

    private Integer groundEntityNum;

    private Integer constantLight;
    private Integer loopSound;

    private Integer modelIndex;
    private Integer modelIndex2;
    private Integer clientNum;
    private Integer frame;

    private Integer solid;

    private Integer event;
    private Integer eventParm;

    private Integer powerups;
    private Integer weapon;
    private Integer legsAnim;
    private Integer torsoAnim;

    private Integer generic1;

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber( Integer number )
    {
        this.number = number;
    }

    public Integer getEntityType()
    {
        return entityType;
    }

    public void setEntityType( Integer entityType )
    {
        this.entityType = entityType;
    }

    public Integer getEntityFlags()
    {
        return entityFlags;
    }

    public void setEntityFlags( Integer entityFlags )
    {
        this.entityFlags = entityFlags;
    }

    public Trajectory getPosition()
    {
        return position;
    }

    public void setPosition( Trajectory position )
    {
        this.position = position;
    }

    public Trajectory getAngle()
    {
        return angle;
    }

    public void setAngle( Trajectory angle )
    {
        this.angle = angle;
    }

    public Integer getTime()
    {
        return time;
    }

    public void setTime( Integer time )
    {
        this.time = time;
    }

    public Integer getTime2()
    {
        return time2;
    }

    public void setTime2( Integer time2 )
    {
        this.time2 = time2;
    }

    public Float[] getOrigin()
    {
        return origin;
    }

    public void setOrigin( Float[] origin )
    {
        this.origin = origin;
    }

    public Float[] getOrigin2()
    {
        return origin2;
    }

    public void setOrigin2( Float[] origin2 )
    {
        this.origin2 = origin2;
    }

    public Float[] getAngles()
    {
        return angles;
    }

    public void setAngles( Float[] angles )
    {
        this.angles = angles;
    }

    public Float[] getAngles2()
    {
        return angles2;
    }

    public void setAngles2( Float[] angles2 )
    {
        this.angles2 = angles2;
    }

    public Integer getOtherEntityNum()
    {
        return otherEntityNum;
    }

    public void setOtherEntityNum( Integer otherEntityNum )
    {
        this.otherEntityNum = otherEntityNum;
    }

    public Integer getOtherEntityNum2()
    {
        return otherEntityNum2;
    }

    public void setOtherEntityNum2( Integer otherEntityNum2 )
    {
        this.otherEntityNum2 = otherEntityNum2;
    }

    public Integer getGroundEntityNum()
    {
        return groundEntityNum;
    }

    public void setGroundEntityNum( Integer groundEntityNum )
    {
        this.groundEntityNum = groundEntityNum;
    }

    public Integer getConstantLight()
    {
        return constantLight;
    }

    public void setConstantLight( Integer constantLight )
    {
        this.constantLight = constantLight;
    }

    public Integer getLoopSound()
    {
        return loopSound;
    }

    public void setLoopSound( Integer loopSound )
    {
        this.loopSound = loopSound;
    }

    public Integer getModelIndex()
    {
        return modelIndex;
    }

    public void setModelIndex( Integer modelIndex )
    {
        this.modelIndex = modelIndex;
    }

    public Integer getModelIndex2()
    {
        return modelIndex2;
    }

    public void setModelIndex2( Integer modelIndex2 )
    {
        this.modelIndex2 = modelIndex2;
    }

    public Integer getClientNum()
    {
        return clientNum;
    }

    public void setClientNum( Integer clientNum )
    {
        this.clientNum = clientNum;
    }

    public Integer getFrame()
    {
        return frame;
    }

    public void setFrame( Integer frame )
    {
        this.frame = frame;
    }

    public Integer getSolid()
    {
        return solid;
    }

    public void setSolid( Integer solid )
    {
        this.solid = solid;
    }

    public Integer getEvent()
    {
        return event;
    }

    public void setEvent( Integer event )
    {
        this.event = event;
    }

    public Integer getEventParm()
    {
        return eventParm;
    }

    public void setEventParm( Integer eventParm )
    {
        this.eventParm = eventParm;
    }

    public Integer getPowerups()
    {
        return powerups;
    }

    public void setPowerups( Integer powerups )
    {
        this.powerups = powerups;
    }

    public Integer getWeapon()
    {
        return weapon;
    }

    public void setWeapon( Integer weapon )
    {
        this.weapon = weapon;
    }

    public Integer getLegsAnim()
    {
        return legsAnim;
    }

    public void setLegsAnim( Integer legsAnim )
    {
        this.legsAnim = legsAnim;
    }

    public Integer getTorsoAnim()
    {
        return torsoAnim;
    }

    public void setTorsoAnim( Integer torsoAnim )
    {
        this.torsoAnim = torsoAnim;
    }

    public Integer getGeneric1()
    {
        return generic1;
    }

    public void setGeneric1( Integer generic1 )
    {
        this.generic1 = generic1;
    }
}
