package com.hardik.seaminaction.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import com.hardik.seaminaction.model.Golfer;

@Name("golferList")
public class GolferList extends EntityQuery<Golfer>
{
    public GolferList()
    {
        setEjbql("select golfer from Golfer golfer");
    }
}
