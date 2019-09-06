package com.learnjava.springboot.security_001.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IInfoService {
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public String getMsg();
}
