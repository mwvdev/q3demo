package mwvdev.quake.models;

public class Trajectory
{

    private Integer type;
    private Integer time;
    private Integer duration;
    private Float[] base = new Float[3];
    private Float[] delta = new Float[3];
    private Integer gravity;

    public Integer getType()
    {
        return type;
    }

    public void setType( Integer type )
    {
        this.type = type;
    }

    public Integer getTime()
    {
        return time;
    }

    public void setTime( Integer time )
    {
        this.time = time;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public void setDuration( Integer duration )
    {
        this.duration = duration;
    }

    public Float[] getBase()
    {
        return base;
    }

    public void setBase( Float[] base )
    {
        this.base = base;
    }

    public Float[] getDelta()
    {
        return delta;
    }

    public void setDelta( Float[] delta )
    {
        this.delta = delta;
    }

    public Integer getGravity()
    {
        return gravity;
    }

    public void setGravity( Integer gravity )
    {
        this.gravity = gravity;
    }

}
