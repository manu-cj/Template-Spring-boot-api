package com.manu.template.dto;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.UUID;

public class UUIDAdapter extends XmlAdapter<String, UUID> {
    @Override
    public UUID unmarshal(String v) {
        return (v == null) ? null : UUID.fromString(v);
    }

    @Override
    public String marshal(UUID v) {
        return (v == null) ? null : v.toString();
    }
}
