package com.shop.peristence.postgres.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public interface TallaProjection {

    Integer getidSizes();
    String getName();
}
