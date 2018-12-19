package com.iofs.loanmanagementsystem.rest.v1;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/v1")
public class IofsApplication  extends Application {

	@Override
	public Set<Object> getSingletons() {
		Set<Object> set = new HashSet<Object>();
		//TODO
		//set.add(new IofsLmsResource());
		return set;
	}

}
	