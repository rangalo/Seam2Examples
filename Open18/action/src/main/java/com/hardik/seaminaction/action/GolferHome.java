package com.hardik.seaminaction.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.hardik.seaminaction.model.Golfer;

@Name("golferHome")
public class GolferHome extends EntityHome<Golfer>
{
    @RequestParameter Long golferId;

    @Override
    public Object getId()
    {
        if (golferId == null)
        {
            return super.getId();
        }
        else
        {
            return golferId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
