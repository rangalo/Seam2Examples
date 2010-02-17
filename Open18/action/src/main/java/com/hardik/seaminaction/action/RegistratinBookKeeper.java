package com.hardik.seaminaction.action;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.hardik.seaminaction.model.Golfer;

@Name("registratinBookKeeper")
@Scope(ScopeType.APPLICATION)
public class RegistratinBookKeeper {
	@Logger
	private Log logger;
	
	private int cnt = 0;
	
	@Observer("golferRegistered")
	synchronized public void record(Golfer golfer) {
		cnt++;
		logger.info("Golfer registered - username: " + golfer.getUsername());
		logger.info(cnt + " golfers have registered since the last restart");
	}

}
