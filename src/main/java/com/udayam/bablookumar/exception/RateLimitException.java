package com.udayam.bablookumar.exception;

import lombok.Getter;

public class RateLimitException extends Exception {
    
    @Getter
    private long ms;

    public long getMs() {
		return ms;
	}

	public RateLimitException(long ms) {
        super();
        this.ms = ms;
    }
}
