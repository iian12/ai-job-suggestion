package com.dju.backend.global;

import io.hypersistence.tsid.TSID;
import org.springframework.stereotype.Component;

@Component
public class TsidIdGenerator implements IdGenerator {
    @Override
    public long nextId() {
        return TSID.fast().toLong();
    }
}
